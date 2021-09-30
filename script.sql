CREATE  database gateway_management;

use gateway_management;


CREATE  TABLE IF NOT EXISTS `gateway_management`.`Gateway_Device`
 (
  `id` INT  auto_increment ,
  `serial_number` VARCHAR(150) NOT NULL unique,
  
`human_readable_name` VARCHAR(150) ,
  `IPv4_address` VARCHAR(150) ,
 
 PRIMARY KEY (`id`) )
ENGINE = InnoDB;



CREATE  TABLE IF NOT EXISTS `gateway_management`.`peripheral_device` 
(
  `UID` INT  auto_increment ,
  
`Vendor` VARCHAR(150) NOT NULL,
  `date` date,
  `status` VARCHAR(100) ,
  
`gateway_id` INT,
  PRIMARY KEY (`UID`),
  INDEX forignkey (gateway_id),
   
 FOREIGN KEY (gateway_id)
        REFERENCES Gateway_Device(id)
        ON DELETE CASCADE
  )
ENGINE = InnoDB;

