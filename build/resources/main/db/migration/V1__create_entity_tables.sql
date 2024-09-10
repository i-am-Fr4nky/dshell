create table if not exists app_schema.product -- TODO без использования схемы
(
    id                  bigint          not null primary key,
    name                varchar(255)    not null,
    weight              decimal         not null,
    type_of_packaging   varchar(255)    not null,
    price               decimal         not null,
    categoty_id         bigint          not null
);

