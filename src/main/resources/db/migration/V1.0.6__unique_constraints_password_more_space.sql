ALTER TABLE user
  MODIFY password VARCHAR(150);

ALTER TABLE director
  DROP COLUMN last_name;
ALTER TABLE director
  CHANGE COLUMN first_name full_name VARCHAR(255);

ALTER TABLE actor
  DROP COLUMN last_name;
ALTER TABLE actor
  CHANGE COLUMN first_name full_name VARCHAR(255);

ALTER TABLE author
  DROP COLUMN last_name;
ALTER TABLE author
  CHANGE COLUMN first_name full_name VARCHAR(255);

# UNIQUE_CONSTRAINTS
set FOREIGN_KEY_CHECKS = 0;
truncate table book;
ALTER TABLE book
  ADD CONSTRAINT uqx_ttl UNIQUE (title);
set FOREIGN_KEY_CHECKS = 1;

ALTER TABLE user
  ADD CONSTRAINT uqx_usrnm UNIQUE (username);

ALTER TABLE director
  ADD CONSTRAINT uqx_drctr UNIQUE (full_name);

ALTER TABLE actor
  ADD CONSTRAINT uqx_actr UNIQUE (full_name);

ALTER TABLE author
  ADD CONSTRAINT uqx_athr UNIQUE (full_name);

ALTER TABLE activity_type
  ADD CONSTRAINT uqx_ctvttp UNIQUE (activity_type);

ALTER TABLE setting
  ADD CONSTRAINT uqx_sttng UNIQUE (setting);