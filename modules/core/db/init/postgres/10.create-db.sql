-- begin GENPRO_DOC
create table GENPRO_DOC (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    JSON_BODY text,
    doc_j jsonb,
    --
    primary key (ID)
)^
-- end GENPRO_DOC
-- begin JSONB_PERSON
create table JSONB_PERSON (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    ADDRESS jsonb,
    --
    primary key (ID)
)^
-- end JSONB_PERSON
