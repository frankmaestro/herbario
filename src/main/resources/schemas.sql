
DROP TABLE IF EXISTS public.university_test

CREATE TABLE IF NOT EXISTS public.university_test
(
    id integer NOT NULL,
    code character varying(255) COLLATE pg_catalog."default",
    create_date timestamp without time zone,
    name character varying(255) COLLATE pg_catalog."default",
    notifield_date timestamp without time zone,
    uuid character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT universitykey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.university_test
    OWNER to postgres;