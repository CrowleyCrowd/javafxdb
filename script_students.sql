-- Table: public.students

-- DROP TABLE IF EXISTS public.students;

CREATE TABLE IF NOT EXISTS public.students
(
    student_id character varying(20) COLLATE pg_catalog."default" NOT NULL,
    student_firstname character varying(50) COLLATE pg_catalog."default" NOT NULL,
    student_lastname character varying(50) COLLATE pg_catalog."default" NOT NULL,
    student_birthdate date NOT NULL,
    student_email character varying(50) COLLATE pg_catalog."default" NOT NULL,
    student_phone character varying(50) COLLATE pg_catalog."default" NOT NULL,
    student_level integer NOT NULL,
    CONSTRAINT student_pkey PRIMARY KEY (student_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.students
    OWNER to efrenn;