INSERT INTO delfosapi.permission (id, description) values (1, 'ROLE_SEARCH_BILL');
INSERT INTO delfosapi.permission (id, description) values (2, 'ROLE_DISABLE_USER');

INSERT INTO delfosapi.user_permission (id_user, id_permission) values (1, 1);
INSERT INTO delfosapi.user_permission (id_user, id_permission) values (1, 2);