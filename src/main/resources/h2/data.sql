DROP TABLE products IF EXISTS;
DROP TABLE meals IF EXISTS;
DROP TABLE mealxprod IF EXISTS;
DROP TABLE diets IF EXISTS;
DROP TABLE dietxmeal IF EXISTS;


CREATE TABLE products(
ID_PRODUCT INTEGER IDENTITY PRIMARY KEY,
PRODUCT_NAME VARCHAR(20) NOT NULL,
WEIGHT_BASE INTEGER(10) NOT NULL,
WEIGHT_ADD INTEGER(10) NOT NULL,
PROTEIN DECIMAL(4,2),
CARBOHYDRATE DECIMAL(4,2),
FAT DECIMAL(4,2)
);

CREATE TABLE meals(
ID_MEAL INTEGER IDENTITY PRIMARY KEY,
TYPE VARCHAR(20) NOT NULL
);

CREATE TABLE mealxprod(
ID_MEAL INTEGER(10) NOT NULL,
ID_PROD INTEGER(10) NOT NULL,
FOREIGN KEY (ID_MEAL) REFERENCES meals(ID_MEAL),
FOREIGN KEY (ID_PROD) REFERENCES products(ID_PRODUCT)
);

CREATE TABLE diets(
ID_DIET INTEGER IDENTITY PRIMARY KEY,
OPIS VARCHAR(45)
);

CREATE TABLE dietxmeal(
ID_DIET INTEGER(10) NOT NULL,
ID_MEAL INTEGER(10) NOT NULL,
FOREIGN KEY (ID_DIET) REFERENCES diets(ID_DIET),
FOREIGN KEY (ID_MEAL) REFERENCES meals(ID_MEAL)
);

INSERT INTO `products` (`ID_PRODUCT`,`PRODUCT_NAME`,`weight_base`,`weight_add`,`protein`,`carbohydrate`,`fat`) VALUES (1, 'Oatmeal', 30, 10, 11.90, 62.50, 7.20);
INSERT INTO `products` (`ID_PRODUCT`,`PRODUCT_NAME`,`weight_base`,`weight_add`,`protein`,`carbohydrate`,`fat`) VALUES (2, 'Milk', 150, 50, 3.20, 4.70, 2.00);
INSERT INTO `products` (`ID_PRODUCT`,`PRODUCT_NAME`,`weight_base`,`weight_add`,`protein`,`carbohydrate`,`fat`) VALUES (3, 'Chicken breast', 100, 20, 19.30, 0.00, 14.00);
INSERT INTO `products` (`ID_PRODUCT`,`PRODUCT_NAME`,`weight_base`,`weight_add`,`protein`,`carbohydrate`,`fat`) VALUES (4, 'Rice', 100, 50, 8.00, 79.00, 1.00);
INSERT INTO `products` (`ID_PRODUCT`,`PRODUCT_NAME`,`weight_base`,`weight_add`,`protein`,`carbohydrate`,`fat`) VALUES (5, 'Olive oil', 10, 5, 0.00, 0.00, 99.60);
INSERT INTO `products` (`ID_PRODUCT`,`PRODUCT_NAME`,`weight_base`,`weight_add`,`protein`,`carbohydrate`,`fat`) VALUES (6, 'Eggs', 60, 60, 13.00, 1.00, 10.00);
INSERT INTO `products` (`ID_PRODUCT`,`PRODUCT_NAME`,`weight_base`,`weight_add`,`protein`,`carbohydrate`,`fat`) VALUES (7, 'Wholewheat roll', 40, 20, 8.20, 51.60, 1.70);

INSERT INTO `meals` (`ID_MEAL`, `type`) VALUES (1, 'BREAKFAST');
INSERT INTO `meals` (`ID_MEAL`, `type`) VALUES (2, 'DINNER');
INSERT INTO `meals` (`ID_MEAL`, `type`) VALUES (3, 'SUPPER');

INSERT INTO `mealxprod` (`id_meal`, `id_prod`) VALUES (1, 1);
INSERT INTO `mealxprod` (`id_meal`, `id_prod`) VALUES (1, 2);
INSERT INTO `mealxprod` (`id_meal`, `id_prod`) VALUES (2, 3);
INSERT INTO `mealxprod` (`id_meal`, `id_prod`) VALUES (2, 4);
INSERT INTO `mealxprod` (`id_meal`, `id_prod`) VALUES (2, 5);
INSERT INTO `mealxprod` (`id_meal`, `id_prod`) VALUES (3, 6);
INSERT INTO `mealxprod` (`id_meal`, `id_prod`) VALUES (3, 7);

INSERT INTO `diets` (`ID_DIET`, `opis`) VALUES (1, 'dieta klasyczna');

INSERT INTO `dietxmeal` (`ID_DIET`, `ID_MEAL`) VALUES (1, 1);
INSERT INTO `dietxmeal` (`ID_DIET`, `ID_MEAL`) VALUES (1, 2);
INSERT INTO `dietxmeal` (`ID_DIET`, `ID_MEAL`) VALUES (1, 2);
INSERT INTO `dietxmeal` (`ID_DIET`, `ID_MEAL`) VALUES (1, 2);
INSERT INTO `dietxmeal` (`ID_DIET`, `ID_MEAL`) VALUES (1, 3);