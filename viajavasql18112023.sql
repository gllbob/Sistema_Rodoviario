-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.4.28-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Copiando estrutura do banco de dados para viajava
CREATE DATABASE IF NOT EXISTS `viajava` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `viajava`;

-- Copiando estrutura para tabela viajava.cidade
CREATE TABLE IF NOT EXISTS `cidade` (
  `idecidade` bigint(20) NOT NULL,
  `nomcidade` varchar(255) DEFAULT NULL,
  `desuf` char(2) DEFAULT NULL,
  PRIMARY KEY (`idecidade`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Copiando dados para a tabela viajava.cidade: ~3 rows (aproximadamente)
INSERT INTO `cidade` (`idecidade`, `nomcidade`, `desuf`) VALUES
	(2910800, 'Feira de Santana', 'BA'),
	(2927408, 'Salvador', 'BA');

-- Copiando estrutura para tabela viajava.passagem
CREATE TABLE IF NOT EXISTS `passagem` (
  `idepassagem` bigint(20) NOT NULL AUTO_INCREMENT,
  `idecidadeorigem` bigint(20) DEFAULT NULL,
  `idecidadedestino` bigint(20) DEFAULT NULL,
  `ideveiculo` bigint(20) DEFAULT NULL,
  `nropoltrona` int(11) DEFAULT NULL,
  `dtcsaida` date DEFAULT NULL,
  `deshorasaida` varchar(10) DEFAULT NULL,
  `nrovalorpassagem` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`idepassagem`),
  KEY `FK_passagem_cidade` (`idecidadeorigem`),
  KEY `FK_passagem_cidade_2` (`idecidadedestino`),
  KEY `FK_passagem_veiculo` (`ideveiculo`),
  CONSTRAINT `FK_passagem_cidade` FOREIGN KEY (`idecidadeorigem`) REFERENCES `cidade` (`idecidade`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_passagem_cidade_2` FOREIGN KEY (`idecidadedestino`) REFERENCES `cidade` (`idecidade`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_passagem_veiculo` FOREIGN KEY (`ideveiculo`) REFERENCES `veiculo` (`ideveiculo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Copiando dados para a tabela viajava.passagem: ~29 rows (aproximadamente)
INSERT INTO `passagem` (`idepassagem`, `idecidadeorigem`, `idecidadedestino`, `ideveiculo`, `nropoltrona`, `dtcsaida`, `deshorasaida`, `nrovalorpassagem`) VALUES
	(1, 2927408, 2927408, 1, 1, '2023-11-14', '10:00', 50.00),
	(2, 2927408, 2927408, 1, 1, '2023-11-14', '10:00', 50.00),
	(7, 2927408, 2927408, 1, 1, '2023-11-15', '10:10', 50.00),
	(11, 2927408, 2927408, 1, 1, '2023-11-16', '10:10', 50.00),
	(12, 2927408, 2927408, 1, 2, '2023-11-16', '10:10', 50.00),
	(15, 2927408, 2927408, 1, 2, '2023-11-16', '10:10', 50.00),
	(16, 2927408, 2927408, 1, 1, '2023-11-16', '10:10', 50.00),
	(17, 2927408, 2927408, 1, 5, '2023-11-16', '10:10', 50.00),
	(18, 2927408, 2927408, 1, 36, '2023-11-17', '10:10', 50.00),
	(19, 2927408, 2927408, 1, 36, '2023-11-17', '10:10', 50.00),
	(20, 2927408, 2927408, 1, 35, '2023-11-17', '10:10', 50.00),
	(21, 2927408, 2927408, 1, 36, '2023-11-17', '10:10', 50.00),
	(22, 2927408, 2927408, 1, 36, '2023-10-17', '10:10', 50.00),
	(23, 2927408, 2927408, 1, 36, '2023-11-17', '10:10', 50.00),
	(24, 2927408, 2927408, 1, 36, '2023-11-17', '10:10', 50.00),
	(25, 2927408, 2927408, 1, 36, '2023-11-17', '10:10', 50.00),
	(26, 2927408, 2927408, 1, 36, '2023-11-17', '10:10', 50.00),
	(27, 2927408, 2927408, 1, 36, '2023-11-17', '10:10', 50.00),
	(28, 2927408, 2927408, 1, 36, '2023-11-17', '10:10', 50.00),
	(29, 2927408, 2927408, 1, 36, '2023-11-17', '10:10', 50.00),
	(30, 2927408, 2927408, 1, 36, '2023-11-17', '10:10', 50.00),
	(31, 2927408, 2927408, 1, 36, '2023-11-17', '10:10', 50.00),
	(32, 2927408, 2927408, 1, 36, '2023-11-17', '10:10', 50.00),
	(33, 2927408, 2927408, 1, 36, '2023-11-17', '10:10', 50.00),
	(34, 2927408, 2927408, 1, 36, '2023-11-17', '10:10', 50.00),
	(35, 2927408, 2927408, 1, 36, '2023-11-17', '10:10', 50.00),
	(36, 2927408, 2927408, 1, 36, '2023-11-17', '10:10', 50.00),
	(37, 2927408, 2927408, 1, 36, '2023-11-17', '10:10', 50.00),
	(38, 2927408, 2927408, 1, 36, '2023-11-17', '10:10', 50.00),
	(40, 2927408, 2910800, 1, 1, '2023-11-18', '10:10', 50.00);

-- Copiando estrutura para tabela viajava.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `ideusuario` bigint(20) NOT NULL AUTO_INCREMENT,
  `nomusuario` varchar(255) DEFAULT NULL,
  `nomcargo` varchar(255) DEFAULT NULL,
  `deslogin` varchar(255) DEFAULT NULL,
  `dessenha` varchar(255) DEFAULT NULL,
  `desemail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ideusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Copiando dados para a tabela viajava.usuario: ~1 rows (aproximadamente)
INSERT INTO `usuario` (`ideusuario`, `nomusuario`, `nomcargo`, `deslogin`, `dessenha`, `desemail`) VALUES
	(8, 'gllbob', 'adm', 'gllbob', '12345', 't@t'),
	(10, 'Gabriel Lopes Lima', 'ADM', 'glbob', '12345', 't@t');

-- Copiando estrutura para tabela viajava.veiculo
CREATE TABLE IF NOT EXISTS `veiculo` (
  `ideveiculo` bigint(20) NOT NULL AUTO_INCREMENT,
  `desplaca` varchar(255) DEFAULT NULL,
  `nommotorista` varchar(250) NOT NULL,
  `desmodelo` varchar(255) DEFAULT NULL,
  `nroanomodelo` int(11) DEFAULT NULL,
  `nropoltronas` int(11) DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ideveiculo`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Copiando dados para a tabela viajava.veiculo: ~3 rows (aproximadamente)
INSERT INTO `veiculo` (`ideveiculo`, `desplaca`, `nommotorista`, `desmodelo`, `nroanomodelo`, `nropoltronas`, `numero`) VALUES
	(1, '123TE321', 'teste', 'teste', 2022, 36, '123TE321'),
	(3, '321TE321', 'teste2', 'teste2', 2022, 36, '321TE321'),
	(4, '123TE123', 'teste3', 'teste3', 2022, 36, '123TE123');

-- Copiando estrutura para procedure viajava.cadastrarcidade
DELIMITER //
CREATE PROCEDURE `cadastrarcidade`(
	IN `pidecidade` BIGINT,
	IN `pnomcidade` VARCHAR(255),
	IN `pdesuf` VARCHAR(2)
)
BEGIN
    INSERT INTO cidade (idecidade,
	 							nomcidade,  
								desuf) VALUES (pidecidade,
													pnomcidade, 
													pdesuf);
END//
DELIMITER ;

-- Copiando estrutura para procedure viajava.cadastrarpassagem
DELIMITER //
CREATE PROCEDURE `cadastrarpassagem`(
	IN `pidecidadeorigem` BIGINT,
	IN `pidecidadedestino` BIGINT,
	IN `pideveiculo` VARCHAR(20),
	IN `pnropoltrona` INT,
	IN `pdtcsaida` VARCHAR(10),
	IN `pdeshorasaida` VARCHAR(10),
	IN `pnrovalorpassagem` DECIMAL(10, 2)
)
BEGIN
	DECLARE videveiculo BIGINT;
	
	SELECT ideveiculo INTO videveiculo
	FROM veiculo
	WHERE desplaca = pideveiculo;
	
 	INSERT INTO passagem (idecidadeorigem, 
 							  idecidadedestino, 
							  ideveiculo, 
							  nropoltrona, 
							  dtcsaida, 
							  deshorasaida, 
							  nrovalorpassagem) VALUES (pidecidadeorigem, 
							  									 pidecidadedestino, 
																 videveiculo, 
																 pnropoltrona, 
																 STR_TO_DATE(pdtcsaida, '%d/%m/%Y'), 
																 pdeshorasaida, 
																 pnrovalorpassagem);
END//
DELIMITER ;

-- Copiando estrutura para procedure viajava.cadastrarusuario
DELIMITER //
CREATE PROCEDURE `cadastrarusuario`(
	IN `pnomusuario` VARCHAR(255),
	IN `pnomcargo` VARCHAR(255),
	IN `pdeslogin` VARCHAR(255),
	IN `pdessenha` VARCHAR(255),
	IN `pdesemail` VARCHAR(255)
)
BEGIN
    INSERT INTO usuario (nomusuario,
    							nomcargo,
	 							deslogin,  
								dessenha,
								desemail) VALUES (pnomusuario,
														pnomcargo, 
														pdeslogin,
														pdessenha,
														pdesemail);
END//
DELIMITER ;

-- Copiando estrutura para procedure viajava.cadastrarveiculo
DELIMITER //
CREATE PROCEDURE `cadastrarveiculo`(
	IN `pnumero` VARCHAR(255),
	IN `pdesplaca` VARCHAR(10),
	IN `pnommotorista` VARCHAR(255),
	IN `pdesmodelo` VARCHAR(255),
	IN `pnroanomodelo` INT,
	IN `pnroPoltronas` INT
)
BEGIN
    INSERT INTO veiculo (numero,
	 							 desplaca, 
								 nommotorista, 
								 desmodelo, 
								 nroanomodelo, 
								 nropoltronas) VALUES (pnumero,
								 							  pdesplaca, 
															  pnommotorista, 
															  pdesmodelo, 
															  pnroanomodelo, 
															  pnroPoltronas);
END//
DELIMITER ;

-- Copiando estrutura para procedure viajava.consultarcidade
DELIMITER //
CREATE PROCEDURE `consultarcidade`(
	IN `pidecidade` BIGINT
)
BEGIN
    SELECT c.idecidade,
    		  c.nomcidade,
	 	 	  c.desuf
	 FROM cidade c
	 WHERE c.idecidade = pidecidade;
END//
DELIMITER ;

-- Copiando estrutura para procedure viajava.consultarpassagem
DELIMITER //
CREATE PROCEDURE `consultarpassagem`(
	IN `pidepassagem` BIGINT
)
BEGIN
	SELECT p.idepassagem, 
			 p.idecidadeorigem, 
			 p.idecidadedestino, 
			 p.ideveiculo,
			 v.desplaca, 
			 p.nropoltrona, 
			 p.dtcsaida, 
			 p.deshorasaida, 
			 p.nrovalorpassagem
	FROM passagem p,
		  veiculo v
	WHERE v.ideveiculo = p.ideveiculo
	and p.idepassagem = pidepassagem;
END//
DELIMITER ;

-- Copiando estrutura para procedure viajava.consultarveiculo
DELIMITER //
CREATE PROCEDURE `consultarveiculo`(
	IN `pdesplaca` VARCHAR(10)
)
BEGIN
    SELECT v.ideveiculo, v.desplaca, v.nommotorista, v.desmodelo, v.nroanomodelo, v.nropoltronas, v.numero
	 FROM veiculo v
	 WHERE v.desplaca = pdesplaca;
END//
DELIMITER ;

-- Copiando estrutura para procedure viajava.excluirpassagem
DELIMITER //
CREATE PROCEDURE `excluirpassagem`(
    IN pidepassagem BIGINT
)
BEGIN
    DELETE FROM passagem 
	 WHERE idepassagem = pidepassagem;
END//
DELIMITER ;

-- Copiando estrutura para procedure viajava.excluirveiculo
DELIMITER //
CREATE PROCEDURE `excluirveiculo`(
	IN `pdesplaca` CHAR(255)
)
BEGIN
    DELETE FROM veiculo
	 WHERE desplaca = pdesplaca;
END//
DELIMITER ;

-- Copiando estrutura para procedure viajava.spdesfaturamento
DELIMITER //
CREATE PROCEDURE `spdesfaturamento`(
	IN `pdtcinicio` VARCHAR(10),
	IN `pdtcfinal` VARCHAR(10)
)
BEGIN
    SELECT p.idepassagem, 
		 p.idecidadeorigem, 
		 c.nomcidade AS cidadeorigem, 
		 p.idecidadedestino, 
		 c2.nomcidade AS cidadedestino, 
		 p.ideveiculo, 
		 v.desplaca, 
		 p.nropoltrona, 
		 p.dtcsaida, 
		 p.deshorasaida, 
		 p.nrovalorpassagem 
	FROM passagem p, 
		  cidade c,	
		  cidade c2, 
		  veiculo v 
	WHERE c.idecidade = p.idecidadeorigem 
	AND v.ideveiculo = p.ideveiculo 
	AND c2.idecidade = p.idecidadedestino
	AND p.dtcsaida BETWEEN pdtcinicio AND pdtcfinal;
END//
DELIMITER ;

-- Copiando estrutura para procedure viajava.spdeslogin
DELIMITER //
CREATE PROCEDURE `spdeslogin`(
    pdeslogin VARCHAR(255),
    pdessenha VARCHAR(255)
)
BEGIN
    SELECT * FROM usuario WHERE deslogin = pdeslogin AND dessenha = pdessenha;
END//
DELIMITER ;

-- Copiando estrutura para procedure viajava.spstspassagem
DELIMITER //
CREATE PROCEDURE `spstspassagem`(
	IN `pdesplaca` VARCHAR(255),
	IN `pnropoltrona` INT,
	IN `pdtcsaida` DATE
)
BEGIN
	SELECT COUNT(*) AS nro FROM passagem p, veiculo v WHERE v.ideveiculo = p.ideveiculo AND v.desplaca = pdesplaca AND p.nropoltrona = pnropoltrona AND p.dtcsaida = pdtcsaida;
END//
DELIMITER ;

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
