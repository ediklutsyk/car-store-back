CREATE TABLE public.television_set
(
  id SERIAL PRIMARY KEY NOT NULL,
  name VARCHAR(100) NOT NULL ,
  diagonal VARCHAR(20) NOT NULL,
  resolution VARCHAR(50) NOT NULL,
  digital_tuner_band VARCHAR(50) NOT NULL,
  wifi_module BOOLEAN NOT NULL,
  manufacturer VARCHAR(50) NOT NULL,
  special_property VARCHAR(50) NOT NULL,
  description TEXT NOT NULL,
  price REAL NOT NULL ,
  platform VARCHAR(50) NOT NULL ,
  update VARCHAR(50) NOT NULL ,
  sweep VARCHAR(50) NOT NULL ,
  color VARCHAR(50) NOT NULL ,
  size_with_stand VARCHAR(50) NOT NULL ,
  weight_with_stand VARCHAR(50) NOT NULL ,
  main_image VARCHAR(250) NOT NULL,
  amount INT NOT NULL
);
CREATE UNIQUE INDEX television_set_id_uindex ON public.television_set (id);