INSERT INTO ENDERECO VALUES ('1', '111', 'asdasd', 'asdasd', 'ASDA', 'adasd')
INSERT INTO ENDERECO VALUES ('2', '111', 'asdasd', 'asdasd', 'ASDA', 'adasd')

INSERT INTO ENVOLVIDO VALUES ('12323412354', 'asdasd', 'asdasd', 'asdasd', 'ASDA')
INSERT INTO ENVOLVIDO VALUES ('12323412353', 'asdasd', 'asdasd', 'asdasd', 'ASDA')

INSERT INTO PLACA VALUES ('asda', '123asdd', 'asdastd')
INSERT INTO PLACA VALUES ('asvb', '156agbd', 'asdasd')

INSERT INTO VEICULO VALUES ('2010', 'asdad12333', 'azul', '123asdd', null, 'asdas', 'fiat')
INSERT INTO VEICULO VALUES ('2011', 'dg56asfffa', 'branco', '156agbd', null, 'asdas', 'fiat')

INSERT INTO BOLETIM_FURTO VALUES ('2004-12-31', '1', '"Furto (art. 155) - VEICULO"', 'xcv', 'as112-1asdd', 'sdf', 'asdad12333')
INSERT INTO BOLETIM_FURTO VALUES ('2004-12-31', '2', '"Furto (art. 155) - VEICULO"', 'asd', 'bh112-145dd', '123', 'dg56asfffa')

UPDATE VEICULO SET ENVOLVIDO_EM_IDENTIFICADOR = 'as112-1asdd' WHERE CHASSI = 'asdad12333'
UPDATE VEICULO SET ENVOLVIDO_EM_IDENTIFICADOR = 'bh112-145dd' WHERE CHASSI = 'dg56asfffa'