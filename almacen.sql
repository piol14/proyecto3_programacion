-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema almacen
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema almacen
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `almacen` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;
USE `almacen` ;

-- -----------------------------------------------------
-- Table `almacen`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almacen`.`categoria` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `almacen`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almacen`.`producto` (
  `idproducto` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `precio` DECIMAL(3) NOT NULL,
  `existencias` INT NOT NULL,
  `categoria_id` INT NOT NULL,
  PRIMARY KEY (`idproducto`),
  INDEX `fk_producto_categoria_idx` (`categoria_id` ASC) VISIBLE,
  CONSTRAINT `fk_producto_categoria`
    FOREIGN KEY (`categoria_id`)
    REFERENCES `almacen`.`categoria` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
