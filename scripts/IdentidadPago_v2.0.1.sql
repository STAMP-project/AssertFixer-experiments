START TRANSACTION;
ALTER TABLE sic.pago ADD nroPago BIGINT(20);
SET SQL_SAFE_UPDATES=0;
UPDATE sic.pago SET nroPago = id_Pago;
SET SQL_SAFE_UPDATES=1;
COMMIT;
