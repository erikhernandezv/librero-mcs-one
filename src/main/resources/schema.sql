CREATE DATABASE librero12345678
    WITH
    OWNER = "librero-mcs-one"
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

CREATE TABLE IF NOT EXISTS public.autor
(
    id integer NOT NULL DEFAULT nextval('autor_id_seq'::regclass),
    nombre character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT autor_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.autor
    OWNER to "librero-mcs-one";

CREATE TABLE IF NOT EXISTS public.categoria
(
    id integer NOT NULL DEFAULT nextval('categoria_id_seq'::regclass),
    nombre character varying COLLATE pg_catalog."default" NOT NULL,
    descripcion character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT categoria_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.categoria
    OWNER to "librero-mcs-one";

CREATE TABLE IF NOT EXISTS public.libros
(
    id integer NOT NULL DEFAULT nextval('libros_id_seq'::regclass),
    titulo character varying COLLATE pg_catalog."default" NOT NULL,
    idautor integer NOT NULL,
    idcategoria integer NOT NULL,
    CONSTRAINT libros_pkey PRIMARY KEY (id),
    CONSTRAINT idautor_fk FOREIGN KEY (idautor)
        REFERENCES public.autor (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID,
    CONSTRAINT idcategoria_fk FOREIGN KEY (idcategoria)
        REFERENCES public.categoria (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.libros
    OWNER to "librero-mcs-one";