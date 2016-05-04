-- Table: hackathon.questions

-- DROP TABLE hackathon.questions;

CREATE TABLE hackathon.questions
(
  id integer NOT NULL,
  ordernumber integer NOT NULL,
  level character varying NOT NULL,
  answer1_text character varying NOT NULL,
  answer1_score integer NOT NULL,
  answer2_text character varying NOT NULL,
  answer2_score integer NOT NULL,
  answer3_text character varying NOT NULL,
  answer3_score integer NOT NULL,
  answer4_text character varying NOT NULL,
  answer4_score integer NOT NULL,
  text character varying,
  pictureurl character varying,
  CONSTRAINT questions_pkey PRIMARY KEY (id)
)

-- Table: hackathon.testresults

-- DROP TABLE hackathon.testresults;

CREATE TABLE hackathon.testresults
(
  username character varying NOT NULL,
  questionid integer,
  answer character(1) NOT NULL,
  id bigserial NOT NULL,
  CONSTRAINT testresults_pkey PRIMARY KEY (id),
  CONSTRAINT testresults_questionid_fkey FOREIGN KEY (questionid)
      REFERENCES hackathon.questions (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)