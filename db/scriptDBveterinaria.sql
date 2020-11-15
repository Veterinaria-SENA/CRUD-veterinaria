-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema clinicavet
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `clinicavet` ;

-- -----------------------------------------------------
-- Schema clinicavet
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `clinicavet` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `clinicavet` ;

-- -----------------------------------------------------
-- Table `clinicavet`.`vacuna`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinicavet`.`vacuna` ;

CREATE TABLE IF NOT EXISTS `clinicavet`.`vacuna` (
  `id_vacuna` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_vacuna`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `clinicavet`.`propietario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinicavet`.`propietario` ;

CREATE TABLE IF NOT EXISTS `clinicavet`.`propietario` (
  `id_propietario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(50) NOT NULL,
  `telefono` VARCHAR(20) NOT NULL,
  `celular` VARCHAR(15) NOT NULL,
  `correo` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id_propietario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `clinicavet`.`mascota`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinicavet`.`mascota` ;

CREATE TABLE IF NOT EXISTS `clinicavet`.`mascota` (
  `id_mascota` INT NOT NULL AUTO_INCREMENT,
  `id_propietario` INT NOT NULL,
  `nombre` VARCHAR(40) NOT NULL,
  `tipo` VARCHAR(25) NOT NULL,
  `raza` VARCHAR(45) NOT NULL,
  `color` VARCHAR(45) NOT NULL,
  `peso` FLOAT NOT NULL,
  `edad` INT NOT NULL,
  `observaciones` VARCHAR(250) NULL DEFAULT NULL,
  PRIMARY KEY (`id_mascota`),
  INDEX `FK_MASCOTA_PROPIETARIO_idx` (`id_propietario` ASC) VISIBLE,
  CONSTRAINT `FK_MASCOTA_PROPIETARIO`
    FOREIGN KEY (`id_propietario`)
    REFERENCES `clinicavet`.`propietario` (`id_propietario`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `clinicavet`.`carnet_vacunacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinicavet`.`carnet_vacunacion` ;

CREATE TABLE IF NOT EXISTS `clinicavet`.`carnet_vacunacion` (
  `id_carnet` INT NOT NULL AUTO_INCREMENT,
  `id_mascota` INT NOT NULL,
  `id_vacuna` INT NOT NULL,
  `fecha` DATE NOT NULL,
  `observaciones` VARCHAR(150) NULL DEFAULT NULL,
  PRIMARY KEY (`id_carnet`),
  INDEX `fk_carnet_vacunacion_mascota_idx` (`id_mascota` ASC) VISIBLE,
  INDEX `fk_carnet_vacunacion_vacuna1_idx` (`id_vacuna` ASC) VISIBLE,
  CONSTRAINT `fk_carnet_vacunacion_vacuna1`
    FOREIGN KEY (`id_vacuna`)
    REFERENCES `clinicavet`.`vacuna` (`id_vacuna`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_carnet_vacunacion_mascota`
    FOREIGN KEY (`id_mascota`)
    REFERENCES `clinicavet`.`mascota` (`id_mascota`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `clinicavet`.`historia_clinica`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinicavet`.`historia_clinica` ;

CREATE TABLE IF NOT EXISTS `clinicavet`.`historia_clinica` (
  `id_historia_clinica` INT NOT NULL AUTO_INCREMENT,
  `id_mascota` INT NOT NULL,
  `fecha_apertura` DATE NOT NULL,
  PRIMARY KEY (`id_historia_clinica`),
  INDEX `fk_historia_clinica_mascota1_idx` (`id_mascota` ASC) VISIBLE,
  CONSTRAINT `fk_historia_clinica_mascota1`
    FOREIGN KEY (`id_mascota`)
    REFERENCES `clinicavet`.`mascota` (`id_mascota`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `clinicavet`.`tipo_consulta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinicavet`.`tipo_consulta` ;

CREATE TABLE IF NOT EXISTS `clinicavet`.`tipo_consulta` (
  `id_tipo_consulta` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id_tipo_consulta`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `clinicavet`.`veterinario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinicavet`.`veterinario` ;

CREATE TABLE IF NOT EXISTS `clinicavet`.`veterinario` (
  `id_veterinario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(20) NOT NULL,
  `celular` VARCHAR(15) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_veterinario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `clinicavet`.`consulta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinicavet`.`consulta` ;

CREATE TABLE IF NOT EXISTS `clinicavet`.`consulta` (
  `id_consulta` INT NOT NULL AUTO_INCREMENT,
  `id_historia_clinica` INT NOT NULL,
  `id_veterinario` INT NOT NULL,
  `fecha` DATE NOT NULL,
  `id_tipo_consulta` INT NOT NULL,
  `diagnostico` VARCHAR(250) NOT NULL,
  PRIMARY KEY (`id_consulta`),
  INDEX `fk_consulta_tipo_consulta1_idx` (`id_tipo_consulta` ASC) VISIBLE,
  INDEX `fk_consulta_historia_clinica1_idx` (`id_historia_clinica` ASC) VISIBLE,
  INDEX `fk_consulta_veterinario1_idx` (`id_veterinario` ASC) VISIBLE,
  CONSTRAINT `fk_consulta_historia_clinica1`
    FOREIGN KEY (`id_historia_clinica`)
    REFERENCES `clinicavet`.`historia_clinica` (`id_historia_clinica`),
  CONSTRAINT `fk_consulta_tipo_consulta1`
    FOREIGN KEY (`id_tipo_consulta`)
    REFERENCES `clinicavet`.`tipo_consulta` (`id_tipo_consulta`),
  CONSTRAINT `fk_consulta_veterinario1`
    FOREIGN KEY (`id_veterinario`)
    REFERENCES `clinicavet`.`veterinario` (`id_veterinario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `clinicavet`.`especialidad`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinicavet`.`especialidad` ;

CREATE TABLE IF NOT EXISTS `clinicavet`.`especialidad` (
  `id_especialidad` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id_especialidad`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `clinicavet`.`veterinario_has_especialidad`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinicavet`.`veterinario_has_especialidad` ;

CREATE TABLE IF NOT EXISTS `clinicavet`.`veterinario_has_especialidad` (
  `id_especialidad` INT NOT NULL,
  `id_veterinario` INT NOT NULL,
  PRIMARY KEY (`id_especialidad`, `id_veterinario`),
  INDEX `fk_especialidad_has_veterinario_veterinario1_idx` (`id_veterinario` ASC) VISIBLE,
  INDEX `fk_especialidad_has_veterinario_especialidad1_idx` (`id_especialidad` ASC) VISIBLE,
  CONSTRAINT `fk_especialidad_has_veterinario_especialidad1`
    FOREIGN KEY (`id_especialidad`)
    REFERENCES `clinicavet`.`especialidad` (`id_especialidad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_especialidad_has_veterinario_veterinario1`
    FOREIGN KEY (`id_veterinario`)
    REFERENCES `clinicavet`.`veterinario` (`id_veterinario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

#consulta
INSERT INTO `clinicavet`.`consulta` (`id_consulta`, `id_historia_clinica`, `id_veterinario`, `fecha`, `id_tipo_consulta`, `diagnostico`) VALUES ('1', '1', '5', '2020-11-13', '2', 'desparacitar');
INSERT INTO `clinicavet`.`consulta` (`id_consulta`, `id_historia_clinica`, `id_veterinario`, `fecha`, `id_tipo_consulta`, `diagnostico`) VALUES ('2', '2', '7', '2020-11-12', '5', 'cola fracturada');
INSERT INTO `clinicavet`.`consulta` (`id_consulta`, `id_historia_clinica`, `id_veterinario`, `fecha`, `id_tipo_consulta`, `diagnostico`) VALUES ('3', '3', '8', '2020-11-10', '4', 'lesion ocular');
INSERT INTO `clinicavet`.`consulta` (`id_consulta`, `id_historia_clinica`, `id_veterinario`, `fecha`, `id_tipo_consulta`, `diagnostico`) VALUES ('4', '4', '6', '2020-11-12', '2', 'descamacion de piel');
INSERT INTO `clinicavet`.`consulta` (`id_consulta`, `id_historia_clinica`, `id_veterinario`, `fecha`, `id_tipo_consulta`, `diagnostico`) VALUES ('5', '5', '3', '2020-11-11', '6', 'cirugia ');
INSERT INTO `clinicavet`.`consulta` (`id_consulta`, `id_historia_clinica`, `id_veterinario`, `fecha`, `id_tipo_consulta`, `diagnostico`) VALUES ('6', '6', '5', '2020-11-08', '2', 'vacuna');
INSERT INTO `clinicavet`.`consulta` (`id_consulta`, `id_historia_clinica`, `id_veterinario`, `fecha`, `id_tipo_consulta`, `diagnostico`) VALUES ('7', '7', '5', '2020-11-12', '2', 'vacuna');
INSERT INTO `clinicavet`.`consulta` (`id_consulta`, `id_historia_clinica`, `id_veterinario`, `fecha`, `id_tipo_consulta`, `diagnostico`) VALUES ('8', '8', '7', '2020-11-07', '4', 'pata fracturada');
INSERT INTO `clinicavet`.`consulta` (`id_consulta`, `id_historia_clinica`, `id_veterinario`, `fecha`, `id_tipo_consulta`, `diagnostico`) VALUES ('9', '9', '1', '2020-11-15', '11', 'radiografia');
INSERT INTO `clinicavet`.`consulta` (`id_consulta`, `id_historia_clinica`, `id_veterinario`, `fecha`, `id_tipo_consulta`, `diagnostico`) VALUES ('10', '10', '5', '2020-11-01', '2', 'control pulgas');


#carnet_vacunacion
INSERT INTO `clinicavet`.`carnet_vacunacion` (`id_carnet`, `id_mascota`, `id_vacuna`, `fecha`, `observaciones`) VALUES ('1', '1', '11', '2020-01-12', 'primer dosis');
INSERT INTO `clinicavet`.`carnet_vacunacion` (`id_carnet`, `id_mascota`, `id_vacuna`, `fecha`, `observaciones`) VALUES ('2', '2', '12', '2020-03-27', 'primer dosis');
INSERT INTO `clinicavet`.`carnet_vacunacion` (`id_carnet`, `id_mascota`, `id_vacuna`, `fecha`, `observaciones`) VALUES ('3', '3', '13', '2020-01-12', 'primer dosis');
INSERT INTO `clinicavet`.`carnet_vacunacion` (`id_carnet`, `id_mascota`, `id_vacuna`, `fecha`, `observaciones`) VALUES ('4', '4', '14', '2020-06-06', 'primer dosis');
INSERT INTO `clinicavet`.`carnet_vacunacion` (`id_carnet`, `id_mascota`, `id_vacuna`, `fecha`, `observaciones`) VALUES ('5', '5', '15', '2020-03-12', 'primer dosis');
INSERT INTO `clinicavet`.`carnet_vacunacion` (`id_carnet`, `id_mascota`, `id_vacuna`, `fecha`, `observaciones`) VALUES ('6', '6', '16', '2020-09-11', 'primer dosis');
INSERT INTO `clinicavet`.`carnet_vacunacion` (`id_carnet`, `id_mascota`, `id_vacuna`, `fecha`, `observaciones`) VALUES ('7', '7', '12', '2020-10-02', 'primer dosis');
INSERT INTO `clinicavet`.`carnet_vacunacion` (`id_carnet`, `id_mascota`, `id_vacuna`, `fecha`, `observaciones`) VALUES ('8', '8', '13', '2020-11-14', 'primer dosis');
INSERT INTO `clinicavet`.`carnet_vacunacion` (`id_carnet`, `id_mascota`, `id_vacuna`, `fecha`, `observaciones`) VALUES ('9', '9', '14', '2020-08-09', 'primer dosis');
INSERT INTO `clinicavet`.`carnet_vacunacion` (`id_carnet`, `id_mascota`, `id_vacuna`, `fecha`, `observaciones`) VALUES ('10', '10', '13', '2020-04-17', 'primer dosis');

#historia_clinica 
INSERT INTO `clinicavet`.`historia_clinica` (`id_historia_clinica`, `id_mascota`, `fecha_apertura`) VALUES ('1', '1', '2020-11-04');
INSERT INTO `clinicavet`.`historia_clinica` (`id_historia_clinica`, `id_mascota`, `fecha_apertura`) VALUES ('2', '2', '2020-11-05');
INSERT INTO `clinicavet`.`historia_clinica` (`id_historia_clinica`, `id_mascota`, `fecha_apertura`) VALUES ('3', '3', '2020-11-06');
INSERT INTO `clinicavet`.`historia_clinica` (`id_historia_clinica`, `id_mascota`, `fecha_apertura`) VALUES ('4', '4', '2020-11-07');
INSERT INTO `clinicavet`.`historia_clinica` (`id_historia_clinica`, `id_mascota`, `fecha_apertura`) VALUES ('5', '5', '2020-11-08');
INSERT INTO `clinicavet`.`historia_clinica` (`id_historia_clinica`, `id_mascota`, `fecha_apertura`) VALUES ('6', '6', '2020-11-09');
INSERT INTO `clinicavet`.`historia_clinica` (`id_historia_clinica`, `id_mascota`, `fecha_apertura`) VALUES ('7', '7', '2020-11-10');
INSERT INTO `clinicavet`.`historia_clinica` (`id_historia_clinica`, `id_mascota`, `fecha_apertura`) VALUES ('8', '8', '2020-11-11');
INSERT INTO `clinicavet`.`historia_clinica` (`id_historia_clinica`, `id_mascota`, `fecha_apertura`) VALUES ('9', '9', '2020-11-12');
INSERT INTO `clinicavet`.`historia_clinica` (`id_historia_clinica`, `id_mascota`, `fecha_apertura`) VALUES ('10', '10', '2020-11-013');

#mascota 
INSERT INTO `clinicavet`.`mascota` (`id_mascota`, `id_propietario`, `nombre`, `tipo`, `raza`, `color`, `peso`, `edad`, `observaciones`) VALUES ('1', '1030583067', 'haku', 'gato', 'bombay', 'negro', '4', '5', 'ninguna');
INSERT INTO `clinicavet`.`mascota` (`id_mascota`, `id_propietario`, `nombre`, `tipo`, `raza`, `color`, `peso`, `edad`, `observaciones`) VALUES ('2', '1030583067', 'simon', 'gato', 'albino', 'blanco', '4', '4', 'ninguna');
INSERT INTO `clinicavet`.`mascota` (`id_mascota`, `id_propietario`, `nombre`, `tipo`, `raza`, `color`, `peso`, `edad`, `observaciones`) VALUES ('3', '1030583067', 'lupita', 'gato', 'bombay', 'negro', '3', '4', 'manchas  blancas');
INSERT INTO `clinicavet`.`mascota` (`id_mascota`, `id_propietario`, `nombre`, `tipo`, `raza`, `color`, `peso`, `edad`, `observaciones`) VALUES ('4', '1030583067', 'copito', 'gato', 'siames', 'crema', '4', '4', 'pelo color crema y gris');
INSERT INTO `clinicavet`.`mascota` (`id_mascota`, `id_propietario`, `nombre`, `tipo`, `raza`, `color`, `peso`, `edad`, `observaciones`) VALUES ('5', '1030583067', 'logan', 'gato', 'ruso azul', 'gris', '5', '4', 'ninguna');
INSERT INTO `clinicavet`.`mascota` (`id_mascota`, `id_propietario`, `nombre`, `tipo`, `raza`, `color`, `peso`, `edad`, `observaciones`) VALUES ('6', '1030583067', 'gilly', 'gato', 'siames', 'crema', '3', '1', 'pelo crema y cafe');
INSERT INTO `clinicavet`.`mascota` (`id_mascota`, `id_propietario`, `nombre`, `tipo`, `raza`, `color`, `peso`, `edad`, `observaciones`) VALUES ('7', '1030583067', 'sally', 'gato', 'bombay', 'negro', '3', '1', 'ninguna');
INSERT INTO `clinicavet`.`mascota` (`id_mascota`, `id_propietario`, `nombre`, `tipo`, `raza`, `color`, `peso`, `edad`, `observaciones`) VALUES ('8', '1030583067', 'nymerio', 'gato', 'bombay', 'negro', '4', '3', 'ninguna');
INSERT INTO `clinicavet`.`mascota` (`id_mascota`, `id_propietario`, `nombre`, `tipo`, `raza`, `color`, `peso`, `edad`, `observaciones`) VALUES ('9', '1030583067', 'kiki', 'gato', 'bombay', 'negro', '4', '4', 'ninguna');
INSERT INTO `clinicavet`.`mascota` (`id_mascota`, `id_propietario`, `nombre`, `tipo`, `raza`, `color`, `peso`, `edad`, `observaciones`) VALUES ('10', '35404562', 'dara', 'perro', 'pequinez', 'amarillo', '6', '8', 'ninguna');

#propietario
INSERT INTO `clinicavet`.`propietario` (`id_propietario`, `nombre`, `apellido`, `direccion`, `telefono`, `celular`, `correo`) VALUES ('1030583067', 'Adriana', 'Ortiz', 'calle 45 #50- 96', '2456834', '31283524728', 'adri26.ortiz@gmail.com');
INSERT INTO `clinicavet`.`propietario` (`id_propietario`, `nombre`, `apellido`, `direccion`, `telefono`, `celular`, `correo`) VALUES ('35404562', 'Martha', 'Torres', 'cra 87 i # 54 f 34 sur', '3652783', '3123524728', 'marthatg@gmail.com');

#tipo_consulta
INSERT INTO `clinicavet`.`tipo_consulta` (`id_tipo_consulta`, `nombre`) VALUES ('1', 'Hospitalizacion');
INSERT INTO `clinicavet`.`tipo_consulta` (`id_tipo_consulta`, `nombre`) VALUES ('2', 'MedicinaInterna');
INSERT INTO `clinicavet`.`tipo_consulta` (`id_tipo_consulta`, `nombre`) VALUES ('3', 'Odontologia');
INSERT INTO `clinicavet`.`tipo_consulta` (`id_tipo_consulta`, `nombre`) VALUES ('4', 'Traumatologia');
INSERT INTO `clinicavet`.`tipo_consulta` (`id_tipo_consulta`, `nombre`) VALUES ('5', 'Cirugia');
INSERT INTO `clinicavet`.`tipo_consulta` (`id_tipo_consulta`, `nombre`) VALUES ('6', 'Reproduccion');
INSERT INTO `clinicavet`.`tipo_consulta` (`id_tipo_consulta`, `nombre`) VALUES ('7', 'Ecografias');
INSERT INTO `clinicavet`.`tipo_consulta` (`id_tipo_consulta`, `nombre`) VALUES ('8', 'Endoscopias');
INSERT INTO `clinicavet`.`tipo_consulta` (`id_tipo_consulta`, `nombre`) VALUES ('9', 'Radiografias');
INSERT INTO `clinicavet`.`tipo_consulta` (`id_tipo_consulta`, `nombre`) VALUES ('10', 'Residencia');
INSERT INTO `clinicavet`.`tipo_consulta` (`id_tipo_consulta`, `nombre`) VALUES ('11', 'Medicina General');
INSERT INTO `clinicavet`.`tipo_consulta` (`id_tipo_consulta`, `nombre`) VALUES ('12', 'Urgencias');

#especialidad
INSERT INTO `clinicavet`.`especialidad` (`id_especialidad`, `nombre`) VALUES ('1', 'Ortopedista');
INSERT INTO `clinicavet`.`especialidad` (`id_especialidad`, `nombre`) VALUES ('2', 'Cirujano');
INSERT INTO `clinicavet`.`especialidad` (`id_especialidad`, `nombre`) VALUES ('3', 'Oncologo');
INSERT INTO `clinicavet`.`especialidad` (`id_especialidad`, `nombre`) VALUES ('4', 'Oftalmologo');
INSERT INTO `clinicavet`.`especialidad` (`id_especialidad`, `nombre`) VALUES ('5', 'Fisioterapeuta');
INSERT INTO `clinicavet`.`especialidad` (`id_especialidad`, `nombre`) VALUES ('6', 'Dermatologo');
INSERT INTO `clinicavet`.`especialidad` (`id_especialidad`, `nombre`) VALUES ('7', 'Cardiogo');
INSERT INTO `clinicavet`.`especialidad` (`id_especialidad`, `nombre`) VALUES ('8', 'Neurologo');
INSERT INTO `clinicavet`.`especialidad` (`id_especialidad`, `nombre`) VALUES ('9', 'Médico General');
#veterinario
INSERT INTO `clinicavet`.`veterinario` (`id_veterinario`, `nombre`, `apellido`, `direccion`, `telefono`, `celular`, `correo`) VALUES ('1', 'Camilo Andres', 'Andrade Torres', 'calle 45 # 50 -56', '3664583', '3216435679', 'candrade@gmail.com');
INSERT INTO `clinicavet`.`veterinario` (`id_veterinario`, `nombre`, `apellido`, `direccion`, `telefono`, `celular`, `correo`) VALUES ('2', 'Andrea ', 'Cifuentes Martinez', 'cra 34 # 56 -32', '6783654', '3129764876', 'acifuentes@gmail.com');
INSERT INTO `clinicavet`.`veterinario` (`id_veterinario`, `nombre`, `apellido`, `direccion`, `telefono`, `celular`, `correo`) VALUES ('3', 'Diana Paola', 'Vargas Lopez', 'Av 53 # 76 -23', '7656543', '3017656557', 'dvargas@gmail.com');
INSERT INTO `clinicavet`.`veterinario` (`id_veterinario`, `nombre`, `apellido`, `direccion`, `telefono`, `celular`, `correo`) VALUES ('4', 'Juan Pablo', 'Gomez florez', 'calle 26 # 54 -87', '7998567', '3189923343', 'jgomez@gmail.com');
INSERT INTO `clinicavet`.`veterinario` (`id_veterinario`, `nombre`, `apellido`, `direccion`, `telefono`, `celular`, `correo`) VALUES ('6', 'Maria Camila', 'Diaz Rivera', 'Av 26 # 23 -12', '8990023', '3007639872', 'mdiaz@gmail.com');
INSERT INTO `clinicavet`.`veterinario` (`id_veterinario`, `nombre`, `apellido`, `direccion`, `telefono`, `celular`, `correo`) VALUES ('7', 'Marlon', 'Gutierrez Parra', 'cra 6 # 12- 02 apto 2', '4763987', '3127678958', 'mguiterrez@gmail.com');
INSERT INTO `clinicavet`.`veterinario` (`id_veterinario`, `nombre`, `apellido`, `direccion`, `telefono`, `celular`, `correo`) VALUES ('8', 'Cristian David ', 'Manrique', 'Av 7 # 68- 45', '7677786', '3007786554', 'cmanrique@gmail.com');
INSERT INTO `clinicavet`.`veterinario` (`id_veterinario`, `nombre`, `apellido`, `direccion`, `telefono`, `celular`, `correo`) VALUES ('9', 'Teresa', 'Triana Tobar', 'cra 78 # 23 -13', '9889768', '3128990090', 'ttriana@gmail.com');
INSERT INTO `clinicavet`.`veterinario` (`id_veterinario`, `nombre`, `apellido`, `direccion`, `telefono`, `celular`, `correo`) VALUES ('10', 'Julian Alberto', 'Romero Casas', 'diag 76 # 11-34', '7668121', '3218009892', 'jromero@gmail.com');
INSERT INTO `clinicavet`.`veterinario` (`id_veterinario`, `nombre`, `apellido`, `direccion`, `telefono`, `celular`, `correo`) VALUES ('5', 'Anderson', 'Sandoval Romero', 'calle 47 # 65 - 87', '8769654', '32076598974', 'asandoval@gmail.com');

#veterinario_has_especialidad
INSERT INTO `clinicavet`.`veterinario_has_especialidad` (`id_especialidad`, `id_veterinario`) VALUES ('5', '7');
INSERT INTO `clinicavet`.`veterinario_has_especialidad` (`id_especialidad`, `id_veterinario`) VALUES ('8', '2');
INSERT INTO `clinicavet`.`veterinario_has_especialidad` (`id_especialidad`, `id_veterinario`) VALUES ('2', '4');
INSERT INTO `clinicavet`.`veterinario_has_especialidad` (`id_especialidad`, `id_veterinario`) VALUES ('3', '6');
INSERT INTO `clinicavet`.`veterinario_has_especialidad` (`id_especialidad`, `id_veterinario`) VALUES ('7', '3');
INSERT INTO `clinicavet`.`veterinario_has_especialidad` (`id_especialidad`, `id_veterinario`) VALUES ('4', '8');
INSERT INTO `clinicavet`.`veterinario_has_especialidad` (`id_especialidad`, `id_veterinario`) VALUES ('1', '1');
INSERT INTO `clinicavet`.`veterinario_has_especialidad` (`id_especialidad`, `id_veterinario`) VALUES ('6', '6');
INSERT INTO `clinicavet`.`veterinario_has_especialidad` (`id_especialidad`, `id_veterinario`) VALUES ('2', '3');
INSERT INTO `clinicavet`.`veterinario_has_especialidad` (`id_especialidad`, `id_veterinario`) VALUES ('9', '5');
#vacuna
INSERT INTO `clinicavet`.`vacuna` (`id_vacuna`, `nombre`) VALUES ('1', 'MoquilloCanino');
INSERT INTO `clinicavet`.`vacuna` (`id_vacuna`, `nombre`) VALUES ('2', 'ParvovirosisCanina');
INSERT INTO `clinicavet`.`vacuna` (`id_vacuna`, `nombre`) VALUES ('3', 'Rabia');
INSERT INTO `clinicavet`.`vacuna` (`id_vacuna`, `nombre`) VALUES ('4', 'HepatitisInfecciosaCanina');
INSERT INTO `clinicavet`.`vacuna` (`id_vacuna`, `nombre`) VALUES ('5', 'Leptosis');
INSERT INTO `clinicavet`.`vacuna` (`id_vacuna`, `nombre`) VALUES ('6', 'Parainluenza');
INSERT INTO `clinicavet`.`vacuna` (`id_vacuna`, `nombre`) VALUES ('7', 'Bordetelosis');
INSERT INTO `clinicavet`.`vacuna` (`id_vacuna`, `nombre`) VALUES ('8', 'CoronavirusCanino');
INSERT INTO `clinicavet`.`vacuna` (`id_vacuna`, `nombre`) VALUES ('9', 'EnfermedadLyme');
INSERT INTO `clinicavet`.`vacuna` (`id_vacuna`, `nombre`) VALUES ('10', 'Herpesvirus');
INSERT INTO `clinicavet`.`vacuna` (`id_vacuna`, `nombre`) VALUES ('11', 'PanleucopeniaFelino');
INSERT INTO `clinicavet`.`vacuna` (`id_vacuna`, `nombre`) VALUES ('12', 'RinotraqueitisFelina');
INSERT INTO `clinicavet`.`vacuna` (`id_vacuna`, `nombre`) VALUES ('13', 'CorizaFelino');
INSERT INTO `clinicavet`.`vacuna` (`id_vacuna`, `nombre`) VALUES ('14', 'LeucemiaFelina');
INSERT INTO `clinicavet`.`vacuna` (`id_vacuna`, `nombre`) VALUES ('15', 'PeritonitisInfecciosaFelina');
INSERT INTO `clinicavet`.`vacuna` (`id_vacuna`, `nombre`) VALUES ('16', 'Chlamydiasis');
