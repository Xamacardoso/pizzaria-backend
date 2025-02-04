-- Inserindo os clientes
INSERT INTO customer (customer_name, cpf, email, phone, house_number, street, zip) VALUES ('Xamã Cardoso Mendes Santos', '111-111-111.11', 'xama@gmail.com', '555-555', '3118', 'Rua dos Alfeneiros', '6400000');
INSERT INTO customer (customer_name, cpf, email, phone, house_number, street, zip) VALUES('Nicolas Rafalel', '222-222-222.22', 'nicolas@gmail.com', '685-555', '358', 'Rua dos Loucos Danados', '1233304');

-- Inserindo as pizzas
INSERT INTO pizza (flavor, size, price) VALUES ('Carbonara', 'MEDIUM', 40.0);
INSERT INTO pizza (flavor, size, price) VALUES ('Portuguese', 'LARGE', 60.0);

-- Inserindo os pedidos de cliente (CustomerOrder)
-- Cliente 1
INSERT INTO customer_order (customer_id) VALUES (1); -- Pedido de Xamã Cardoso
-- Vamos supor que o ID gerado para esse pedido é 1

-- Cliente 2
INSERT INTO customer_order (customer_id) VALUES (2); -- Pedido de Nicolas Rafalel
-- Vamos supor que o ID gerado para esse pedido é 2

-- Inserindo os itens do pedido (PizzaOrder)
-- Pedido 1 de Xamã Cardoso (ID = 1)
INSERT INTO pizza_order (order_id, pizza_id, quantity) VALUES (1, 1, 2); -- 2 Carbonara para o pedido de Xamã
INSERT INTO pizza_order (order_id, pizza_id, quantity) VALUES (1, 2, 1); -- 1 Portuguese para o pedido de Xamã

-- Pedido 2 de Nicolas Rafalel (ID = 2)
INSERT INTO pizza_order (order_id, pizza_id, quantity) VALUES (2, 1, 3); -- 3 Carbonara para o pedido de Nicolas
INSERT INTO pizza_order (order_id, pizza_id, quantity) VALUES (2, 2, 2); -- 2 Portuguese para o pedido de Nicolas

-- Observações:
-- A chave primária de cada cliente (ID) e a chave primária de cada pedido (ID) são geradas automaticamente pelo banco de dados.
-- A chave primária de `customer_order` será usada como `order_id` em `pizza_order`.
-- O cálculo do total para cada `customer_order` será feito automaticamente através do métod `calculateTotal()` da classe `CustomerOrder`.

UPDATE customer_order c SET total = ( SELECT SUM(pizza.price * pizza_order.quantity) FROM pizza_order JOIN pizza on pizza_order.pizza_id = pizza.id WHERE pizza_order.order_id = c.id) WHERE c.id IN (1,2);