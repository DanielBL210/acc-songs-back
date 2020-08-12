--
-- PostgreSQL database dump
--

-- Dumped from database version 10.13
-- Dumped by pg_dump version 10.13

-- Started on 2020-08-12 18:39:15

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12924)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2809 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- TOC entry 199 (class 1255 OID 24599)
-- Name: song_create(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.song_create() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
  DECLARE
  BEGIN  
   
	--NEW.create_at:=current_timestamp;

   RETURN NEW;
  END;
$$;


ALTER FUNCTION public.song_create() OWNER TO postgres;

--
-- TOC entry 198 (class 1255 OID 24595)
-- Name: song_update(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.song_update() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
  DECLARE
  BEGIN  
   
	NEW.update_at:=current_timestamp;

   RETURN NEW;
  END;
$$;


ALTER FUNCTION public.song_update() OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 196 (class 1259 OID 24579)
-- Name: songs; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.songs (
    id integer NOT NULL,
    title character varying(200) NOT NULL,
    image character varying(1000) NOT NULL,
    artist character varying(200) NOT NULL,
    genre character varying(200) NOT NULL,
    album character varying(200) NOT NULL,
    user_song character varying(200) NOT NULL,
    create_at timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
    update_at timestamp with time zone DEFAULT CURRENT_TIMESTAMP
);


ALTER TABLE public.songs OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 24597)
-- Name: songs_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.songs ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.songs_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 9000000
    CACHE 1
);


--
-- TOC entry 2800 (class 0 OID 24579)
-- Dependencies: 196
-- Data for Name: songs; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.songs (id, title, image, artist, genre, album, user_song, create_at, update_at) FROM stdin;
6	No es justo	https://cloudfront-us-east-1.images.arcpublishing.com/elespectador/7QBMUAQRIVAW7GADFGXFMDAUDM.jpg	Zion y lennox	Reggaeton	Vibras	Luis	2020-08-12 00:07:26.476-05	2020-08-12 14:52:26.38574-05
7	un verano en nueva york	https://i.ytimg.com/vi/zx_evTYCa40/maxresdefault.jpg	El gran combo de puerto rico	Salsa	El grancombo de puerto rico	daniel	2020-08-12 16:02:19.942-05	2020-08-12 16:02:20.171807-05
9	djadja	https://studiosol-a.akamaihd.net/uploadfile/letras/albuns/d/4/f/5/903071591393809.jpg	aya Nakamura	Pop	nakamura	Pedro	2020-08-12 16:16:47.178-05	2020-08-12 16:16:47.234022-05
8	Tu eres la reina	https://i.ytimg.com/vi/fyuNV1sR1WI/hqdefault.jpg	Diomedes Dias	Vallenato	Titulo de amor	daniel	2020-08-12 16:04:58.254-05	2020-08-12 16:17:27.460803-05
\.


--
-- TOC entry 2810 (class 0 OID 0)
-- Dependencies: 197
-- Name: songs_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.songs_id_seq', 9, true);


--
-- TOC entry 2676 (class 2606 OID 24588)
-- Name: songs songs_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.songs
    ADD CONSTRAINT songs_pkey PRIMARY KEY (id);


--
-- TOC entry 2677 (class 2620 OID 24600)
-- Name: songs song_create; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER song_create BEFORE INSERT ON public.songs FOR EACH ROW EXECUTE PROCEDURE public.song_create();


--
-- TOC entry 2678 (class 2620 OID 24596)
-- Name: songs song_update; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER song_update BEFORE INSERT OR UPDATE ON public.songs FOR EACH ROW EXECUTE PROCEDURE public.song_update();


-- Completed on 2020-08-12 18:39:16

--
-- PostgreSQL database dump complete
--

