insert into delfosapi.flag
(type, description)
values
('Bandeira verde', 'Condições favoráveis de geração de energia. A tarifa não sofre nenhum acréscimo'),
('Bandeira amarela','Condições de geração menos favoráveis. A tarifa sofre acréscimo de R$ 0,01874 para cada quilowatt-hora (kWh) consumidos'),
('Bandeira vermelha - Patamar 1','Condições mais custosas de geração. A tarifa sofre acréscimo de R$ 0,03971 para cada quilowatt-hora kWh consumido'),
('Bandeira vermelha - Patamar 2','condições ainda mais custosas de geração. A tarifa sofre acréscimo de R$ 0,09492 para cada quilowatt-hora kWh consumido');


insert into  delfosapi.tip
(value, title)
values
('Banhos fora do horário de pico', 'Banho'),
('Desligar Equipamentos', 'Desligar Equipamentos'),
('Chuveiros Eletrônicos', 'Chuveiros'),
('Troque Suas Lâmpadas', 'Lâmpadas');



insert into delfosapi.bill
(cash_value, date, kvw_value, type, user_id)
values
('7.1', '2022-06-01', 7.1, 'ENERGIA', 1),
('9.1', '2022-06-01', 9.1, 'KWH', 1),
('7.3', '2022-06-02', 7.3, 'ENERGIA', 1),
('9.5', '2022-06-02', 9.5, 'KWH', 1),
('6.8', '2022-06-03', 6.8, 'ENERGIA', 1),
('8.5', '2022-06-03', 8.5, 'KWH', 1),
('6.6', '2022-06-04', 6.6, 'ENERGIA', 1),
('8.4', '2022-06-04', 8.4, 'KWH', 1),
('5.0', '2022-06-05', 5.0, 'ENERGIA', 1),
('7.1', '2022-06-05', 7.1, 'KWH', 1),
('10.1', '2022-06-06', 10.1, 'ENERGIA', 1),
('11.5', '2022-06-06', 11.5, 'KWH', 1),
('9.4', '2022-06-07', 9.4, 'ENERGIA', 1),
('10.1', '2022-06-07', 10.1, 'KWH', 1),
('8.2', '2022-06-08', 8.2, 'ENERGIA', 1),
('9.7', '2022-06-08', 9.7, 'KWH', 1),
('4.1', '2022-06-09', 4.1, 'ENERGIA', 1),
('5.9', '2022-06-09', 5.9, 'KWH', 1),
('6.1', '2022-06-10', 6.1, 'ENERGIA', 1),
('8.1', '2022-06-10', 8.1, 'KWH', 1),
('7.1', '2022-06-11', 7.1, 'ENERGIA', 1),
('9.1', '2022-06-11', 9.1, 'KWH', 1),
('8.9', '2022-06-12', 8.9, 'ENERGIA', 1),
('10.0', '2022-06-12', 10.0, 'KWH', 1),
('7.6', '2022-06-13', 7.6, 'ENERGIA', 1),
('8.6', '2022-06-13', 8.6, 'KWH', 1),
('6.5', '2022-06-14', 6.5, 'ENERGIA', 1),
('8.5', '2022-06-14', 8.5, 'KWH', 1),
('5.0', '2022-06-15', 5.0, 'ENERGIA', 1),
('7.0', '2022-06-15', 7.0, 'KWH', 1),
('6.4', '2022-06-16', 6.4, 'ENERGIA', 1),
('8.7', '2022-06-16', 8.7, 'KWH', 1),
('7.5', '2022-06-17', 7.5, 'ENERGIA', 1),
('9.5', '2022-06-17', 9.5, 'KWH', 1),
('8.3', '2022-06-18', 8.3, 'ENERGIA', 1),
('10.3', '2022-06-18', 10.3, 'KWH', 1),
('9.9', '2022-06-19', 9.9, 'ENERGIA', 1),
('11.9', '2022-06-19', 11.9, 'KWH', 1),
('7.1', '2022-06-20', 7.1, 'ENERGIA', 1),
('9.1', '2022-06-20', 9.1, 'KWH', 1);
