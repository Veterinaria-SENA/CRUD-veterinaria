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
-- Table `clinicavet`.`carnet_vacunacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinicavet`.`carnet_vacunacion` ;

CREATE TABLE IF NOT EXISTS `clinicavet`.`carnet_vacunacion` (
  `id_carnet` INT NOT NULL AUTO_INCREMENT,
  `id_mascota` INT NOT NULL,
  `id_vacuna` INT NOT NULL,
  `fecha` DATE NOT NULL,
  `observaciones` VARCHAR(150) NULL DEFAULT NULL,
  `vacuna_id_vacuna` INT NOT NULL,
  PRIMARY KEY (`id_carnet`),
  INDEX `fk_carnet_vacunacion_vacuna1_idx` (`vacuna_id_vacuna` ASC) VISIBLE,
  CONSTRAINT `fk_carnet_vacunacion_vacuna1`
    FOREIGN KEY (`vacuna_id_vacuna`)
    REFERENCES `clinicavet`.`vacuna` (`id_vacuna`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
  `id_historia_clinica` INT NOT NULL,
  `carnet_vacunacion_id_carnet` INT NOT NULL,
  PRIMARY KEY (`id_mascota`),
  INDEX `FK_MASCOTA_PROPIETARIO_idx` (`id_propietario` ASC) VISIBLE,
  INDEX `fk_mascota_carnet_vacunacion1_idx` (`carnet_vacunacion_id_carnet` ASC) VISIBLE,
  CONSTRAINT `FK_MASCOTA_PROPIETARIO`
    FOREIGN KEY (`id_propietario`)
    REFERENCES `clinicavet`.`propietario` (`id_propietario`),
  CONSTRAINT `fk_mascota_carnet_vacunacion1`
    FOREIGN KEY (`carnet_vacunacion_id_carnet`)
    REFERENCES `clinicavet`.`carnet_vacunacion` (`id_carnet`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
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
  `mascota_id_mascota` INT NOT NULL,
  PRIMARY KEY (`id_historia_clinica`),
  INDEX `fk_historia_clinica_mascota1_idx` (`mascota_id_mascota` ASC) VISIBLE,
  CONSTRAINT `fk_historia_clinica_mascota1`
    FOREIGN KEY (`mascota_id_mascota`)
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
  `historia_clinica_id_historia_clinica` INT NOT NULL,
  `tipo_consulta_id_tipo_consulta` INT NOT NULL,
  `veterinario_id_veterinario` INT NOT NULL,
  PRIMARY KEY (`id_consulta`),
  INDEX `fk_consulta_historia_clinica1_idx` (`historia_clinica_id_historia_clinica` ASC) VISIBLE,
  INDEX `fk_consulta_tipo_consulta1_idx` (`tipo_consulta_id_tipo_consulta` ASC) VISIBLE,
  INDEX `fk_consulta_veterinario1_idx` (`veterinario_id_veterinario` ASC) VISIBLE,
  CONSTRAINT `fk_consulta_historia_clinica1`
    FOREIGN KEY (`historia_clinica_id_historia_clinica`)
    REFERENCES `clinicavet`.`historia_clinica` (`id_historia_clinica`),
  CONSTRAINT `fk_consulta_tipo_consulta1`
    FOREIGN KEY (`tipo_consulta_id_tipo_consulta`)
    REFERENCES `clinicavet`.`tipo_consulta` (`id_tipo_consulta`),
  CONSTRAINT `fk_consulta_veterinario1`
    FOREIGN KEY (`veterinario_id_veterinario`)
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
-- Table `clinicavet`.`especialidad_has_veterinario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinicavet`.`especialidad_has_veterinario` ;

CREATE TABLE IF NOT EXISTS `clinicavet`.`especialidad_has_veterinario` (
  `especialidad_id_especialidad` INT NOT NULL,
  `veterinario_id_veterinario` INT NOT NULL,
  PRIMARY KEY (`especialidad_id_especialidad`, `veterinario_id_veterinario`),
  INDEX `fk_especialidad_has_veterinario_veterinario1_idx` (`veterinario_id_veterinario` ASC) VISIBLE,
  INDEX `fk_especialidad_has_veterinario_especialidad1_idx` (`especialidad_id_especialidad` ASC) VISIBLE,
  CONSTRAINT `fk_especialidad_has_veterinario_especialidad1`
    FOREIGN KEY (`especialidad_id_especialidad`)
    REFERENCES `clinicavet`.`especialidad` (`id_especialidad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_especialidad_has_veterinario_veterinario1`
    FOREIGN KEY (`veterinario_id_veterinario`)
    REFERENCES `clinicavet`.`veterinario` (`id_veterinario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


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

#especialidad
INSERT INTO `clinicavet`.`especialidad` (`id_especialidad`, `nombre`) VALUES ('1', 'ortopedista');
INSERT INTO `clinicavet`.`especialidad` (`id_especialidad`, `nombre`) VALUES ('2', 'cirujano');
INSERT INTO `clinicavet`.`especialidad` (`id_especialidad`, `nombre`) VALUES ('3', 'oncologo');
INSERT INTO `clinicavet`.`especialidad` (`id_especialidad`, `nombre`) VALUES ('4', 'oftalmologo');
INSERT INTO `clinicavet`.`especialidad` (`id_especialidad`, `nombre`) VALUES ('5', 'fisioterapeuta');
INSERT INTO `clinicavet`.`especialidad` (`id_especialidad`, `nombre`) VALUES ('6', 'dermatologo');
INSERT INTO `clinicavet`.`especialidad` (`id_especialidad`, `nombre`) VALUES ('7', 'cardiogo');
INSERT INTO `clinicavet`.`especialidad` (`id_especialidad`, `nombre`) VALUES ('8', 'neurologo');

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

#especialidad_has_veterinario
INSERT INTO `clinicavet`.`especialidad_has_veterinario` (`especialidad_id_especialidad`, `veterinario_id_veterinario`) VALUES ('5', '7');
INSERT INTO `clinicavet`.`especialidad_has_veterinario` (`especialidad_id_especialidad`, `veterinario_id_veterinario`) VALUES ('1', '2');
INSERT INTO `clinicavet`.`especialidad_has_veterinario` (`especialidad_id_especialidad`, `veterinario_id_veterinario`) VALUES ('2', '4');
INSERT INTO `clinicavet`.`especialidad_has_veterinario` (`especialidad_id_especialidad`, `veterinario_id_veterinario`) VALUES ('3', '6');
INSERT INTO `clinicavet`.`especialidad_has_veterinario` (`especialidad_id_especialidad`, `veterinario_id_veterinario`) VALUES ('7', '3');
INSERT INTO `clinicavet`.`especialidad_has_veterinario` (`especialidad_id_especialidad`, `veterinario_id_veterinario`) VALUES ('4', '8');
INSERT INTO `clinicavet`.`especialidad_has_veterinario` (`especialidad_id_especialidad`, `veterinario_id_veterinario`) VALUES ('8', '1');
INSERT INTO `clinicavet`.`especialidad_has_veterinario` (`especialidad_id_especialidad`, `veterinario_id_veterinario`) VALUES ('6', '6');
INSERT INTO `clinicavet`.`especialidad_has_veterinario` (`especialidad_id_especialidad`, `veterinario_id_veterinario`) VALUES ('2', '3');

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
