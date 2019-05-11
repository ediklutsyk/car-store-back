CREATE TABLE public.image
(
  id SERIAL PRIMARY KEY NOT NULL,
  tv_id INT NOT NULL,
  image VARCHAR(250) NOT NULL,
  CONSTRAINT images_television_set_id_fk FOREIGN KEY (tv_id) REFERENCES television_set (id)
);
CREATE UNIQUE INDEX images_id_uindex ON public.image (id);