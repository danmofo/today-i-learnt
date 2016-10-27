CREATE TABLE IF NOT EXISTS `thing` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `text` TEXT NOT NULL,
  `added` DATETIME NULL DEFAULT NOW(),
  `updated` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `tag` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `value` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `thing_tag` (
  `thing_id` INT NOT NULL,
  `tag_id` INT NOT NULL,
  PRIMARY KEY (`thing_id`, `tag_id`),
  INDEX `fk_thing_has_tag_tag1_idx` (`tag_id` ASC),
  INDEX `fk_thing_has_tag_thing_idx` (`thing_id` ASC),
  CONSTRAINT `fk_thing_has_tag_thing`
    FOREIGN KEY (`thing_id`)
    REFERENCES `thing` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_thing_has_tag_tag1`
    FOREIGN KEY (`tag_id`)
    REFERENCES `tag` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;