INSERT INTO `categoria` (`dtype`, `id`, `created_at`, `delete_soft`, `nome`, `updated_at`) VALUES 
('LIVRO', NULL, '2021-08-15', b'0', 'Ação', NULL), 
('LIVRO', NULL, '2021-08-15', b'0', 'Romance', NULL), 
('LIVRO', NULL, '2021-08-15', b'0', 'Aventura', NULL), 
('LIVRO', NULL, '2021-08-15', b'0', 'História', NULL), 
('LIVRO', NULL, '2021-08-15', b'0', 'Técnico', NULL);

INSERT INTO `categoria` (`dtype`, `id`, `created_at`, `delete_soft`, `nome`, `updated_at`) VALUES 
('PAPELARIA', NULL, '2021-08-15', b'0', 'Escolar', NULL), 
('PAPELARIA', NULL, '2021-08-15', b'0', 'Escritório', NULL), 
('PAPELARIA', NULL, '2021-08-15', b'0', 'Canetas', NULL), 
('PAPELARIA', NULL, '2021-08-15', b'0', 'Pastas', NULL);

INSERT INTO `cliente` (`id`, `ativo`, `cpf`, `created_at`, `data_nascimento`, `delete_soft`, `email`, `nome`, `senha`, `telefone_01`, `telefone_02`, `updated_at`) VALUES 
(NULL, b'1', '314.431.786-16', '2021-08-15', '2000-07-18', b'0', 'priscilaluanamirellavieira-93@kimmay.com.br', 'Priscila Luana Mirella Vieira', '46nSW8cE1F', '(11) 3617-9872', '(11) 98911-7164', NULL), 
(NULL, b'1', '803.676.079-72', '2021-08-15', '1996-03-20', b'0', 'rafaelamaitenogueira__rafaelamaitenogueira@stembalagens.com.br', 'Rafaela Maitê Nogueira', 'IQ1g8nHDWF', '(95) 3565-6059', '(95) 98770-8847', NULL), 
(NULL, b'1', '216.834.092-72', '2021-08-15', '1957-06-08', b'0', 'gustavonicolasjesus_@br.ibm.com', 'Gustavo Nicolas Jesus', 'q81UxLx0G9', '(54) 2657-8994', '(54) 98166-7677', NULL), 
(NULL, b'1', '254.914.156-34', '2021-08-16', '1987-04-18', '', 'brunalizvalentinasantos-82@utbr.com.br', 'Bruna Liz Valentina Santos', 'K3Kl1UFB5u', '(96) 3531-8389', '(96) 98955-8766', NULL), 
(NULL, b'1', '677.672.995-62', '2021-08-15', '1981-05-19', b'0', 'gaelseverinonunes_@andrediaz.com', 'Gael Severino Nunes', 'rEtcqgpobK', '(95) 2956-8204', '(95) 98516-8549', NULL);

INSERT INTO `endereco` (`id`, `bairro`, `cep`, `cidade`, `created_at`, `delete_soft`, `numero`, `rua`, `updated_at`, `cliente_id`) VALUES 
(NULL, 'Colônia Terra Nova', '69093489', 'Manaus', '2021-08-15', b'0', '213', 'Rua das Pedreiras', NULL, '1'),
(NULL, 'Santana', '55645797', 'Gravatá', '2021-08-15', b'0', '181', 'Alameda das Cassuarinas', NULL, '1'),
(NULL, 'Barro Duro', '57045682', 'Maceió', '2021-08-15', b'0', '591', 'Rua Professor Robson Geraldo Costa', NULL, '1'),
(NULL, 'Protásio Alves', '91240630', 'Porto Alegre', '2021-08-15', b'0', '480', 'Rua Vinte e Sete', NULL, '2'),
(NULL, 'Isaura Parente', '69918246', 'Rio Branco', '2021-08-15', b'0', '468', 'Beco Jaguari', NULL, '4'),
(NULL, 'Jorge Teixeira', '69088397', 'Manaus', '2021-08-15', b'0', '685', 'Rua Fausta Massulo', NULL, '4'),
(NULL, 'Capelinha', '40393210', 'Salvador', '2021-08-15', b'0', '202', 'Rua Augusto Públio', NULL, '4'),
(NULL, 'Plano Diretor Sul', '77015318', 'Palmas', '2021-08-15', b'0', 'Palmas', 'Quadra 207 Sul Alameda 9', NULL, '5');

INSERT INTO `chamado` (`id`, `atendido`, `created_at`, `delete_soft`, `descricao`, `titulo`, `updated_at`, `cliente_id`) VALUES 
(NULL, b'1', '2021-08-15', b'0', 'fiz a compra de um produto no dia 15/08 e o produto não está funcionando', 'produto com defeito', NULL, '1'), 
(NULL, b'0', '2021-08-15', b'0', 'Gostaria de fazer a devolução de um pedido. Como devo proceder?', 'devolução de produto', NULL, '4'), 
(NULL, b'0', '2021-08-15', b'0', 'o meu pedido foi extraviado pelos correios, oque acontece com o meu pedido?', 'Pedido extraviado', NULL, '4');

INSERT INTO `estoque` (`id`, `corredor`, `created_at`, `delete_soft`, `prateleira`, `updated_at`) VALUES 
(NULL, '1', '2021-08-15', b'0', 'A', NULL), 
(NULL, '1', '2021-08-15', b'0', 'B', NULL), 
(NULL, '1', '2021-08-15', b'0', 'C', NULL), 
(NULL, '1', '2021-08-15', b'0', 'D', NULL), 
(NULL, '1', '2021-08-15', b'0', 'E', NULL), 
(NULL, '1', '2021-08-15', b'0', 'F', NULL), 
(NULL, '2', '2021-08-15', b'0', 'A', NULL), 
(NULL, '2', '2021-08-15', b'0', 'B', NULL), 
(NULL, '2', '2021-08-15', b'0', 'C', NULL), 
(NULL, '2', '2021-08-15', b'0', 'D', NULL), 
(NULL, '2', '2021-08-15', b'0', 'E', NULL), 
(NULL, '2', '2021-08-15', b'0', 'A', NULL), 
(NULL, '2', '2021-08-15', b'0', 'A', NULL);

INSERT INTO `perfil` (`id`, `nome`) VALUES 
(NULL, 'ROLE_CLIENTE'), 
(NULL, 'ROLE_PADRAO'), 
(NULL, 'ROLE_GERENTE'), 
(NULL, 'ROLE_ADMIN');

INSERT INTO `fornecedor` (`id`, `bairro`, `cep`, `cidade`, `cnpj`, `created_at`, `delete_soft`, `email_01`, `email_02`, `email_03`, `inscricao_estadual`, `nome`, `numero`, `rua`, `telefone_01`, `telefone_02`, `telefone_03`, `updated_at`) VALUES 
(NULL, 'Jardim Canaã II', '13848846', 'Mogi Guaçu', '93.617.232/0001-74', '2021-08-15', b'0', 'marketing@pietraeisaacpaesedocesme.com.br', NULL, NULL, '264.904.542.261', 'Pietra e Isaac Pães e Doces ME', '554', 'Rua José Nunes de Matos', '(19) 2628-2036', '(19) 98497-5798', NULL, NULL), 
(NULL, 'Centro', '07403010', 'Arujá', '88.761.229/0001-90', '2021-08-15', b'0', 'financeiro@laiseagathaesportesme.com.br', 'financeiro2@laiseagathaesportesme.com.br', 'vendas4@laiseagathaesportesme.com.br', '064.274.662.975', 'Laís e Agatha Esportes ME', '573', 'Rua Antonio Francisco de Lima', '', '(11) 3597-7322', '(11) 99104-7270', NULL), 
(NULL, 'Argemiro', '48901090', 'Juazeiro', '25.246.700/0001-91', '2021-08-15', b'0', 'vendas@patriciaenaircomerciodebebidasme.com.br', 'vendas2@patriciaenaircomerciodebebidasme.com.br', NULL, '249014-46', 'Patrícia e Nair Comercio de Bebidas ME', '510', 'Loteamento Argemiro', '(74) 2942-9259', '(74) 98847-2143', NULL, NULL);

INSERT INTO `funcionario` (`id`, `ativo`, `cpf`, `created_at`, `delete_soft`, `nome`, `updated_at`) VALUES 
(NULL, b'0', '790.152.322-02', '2021-08-15', b'0', 'Stefany Juliana Beatriz Peixoto', NULL), 
(NULL, b'1', '662.509.662-85', '2021-08-15', b'0', 'Gabrielly Heloisa Fátima Lima', NULL), 
(NULL, b'1', '533.043.342-89', '2021-08-15', b'0', 'Caroline Patrícia Joana Assunção', NULL), 
(NULL, b'1', '915.360.985-90', '2021-08-15', b'0', 'Juan Heitor Farias', NULL);

INSERT INTO `pedido_reposicao` (`id`, `created_at`, `data_entraga`, `delete_soft`, `descricao`, `obs`, `updated_at`, `valor`, `fornecedor_id`, `funcionario_id`) VALUES 
(NULL, '2021-08-15', '2021-08-17 15:06:53', b'0', '* Caneta Esferográfica 1.0mm Cristal Azul Bic CX - 1000 Unidades\r\n* Caneta pincel Brush Pen 10 cores Intensity 970909 BIC PT - 600 Unidades\r\n* Corretivo líquido 18ml água 930761 BIC BT - 1530 Unidades\r\n* Caneta esferográfica 1.2mm 4 cores Fashion Vivas 1104095 BIC BT - 340 Unidades\r\n* Caneta 4 cores esferográfica retrátil 1.0mm - 845962 - BIC BT - 250 Unidades\r\n* Lápis de Cor 12 cores Evolution sextavado + 4 lápis preto 902545 Bic CX - 640 Unidades', NULL, '2021-08-17', '3950.93', '2', '1'), 
(NULL, '2021-08-15', NULL, b'0', '* Borracha c/Cinta Plástica Neon - Cores Sortidas - 884645 Bic BT - 320 Unidades\r\n* Apontador c/deposito sortido SM/060124ZF Faber Castell BT - 120 Unidades\r\n* Lápis preto n.2 glits redondo SM/935GLIN Faber Castell CX - 230 Unidades\r\n* Apontador simples (Cores Sortidas) SM/060100ZF Faber Castell BT - 310 Unidades', NULL, NULL, '1521.20', '1', '2');

INSERT INTO `funcionario_perfil` (`funcionario_id`, `perfil_id`) VALUES 
('1', '3'), 
('2', '2');

INSERT INTO `produto` (`dtype`, `id`, `created_at`, `delete_soft`, `descricao`, `disponivel`, `nome`, `porcentagem_desconto`, `updated_at`, `valor`, `acabamento`, `altura`, `autor`, `idioma`, `largura`, `numero_paginas`, `pais`, `peso`, `profundidade`, `estoque_id`, `fornecedor_id`, `funcionario_id`) VALUES 
('LIVRO', NULL, '2021-08-15', b'0', 'Entre 1700 e 1800, cerca de dois milhões de homens e mulheres foram arrancados de suas raízes africanas, embarcados à força nos porões dos navios negreiros e transportados para o Brasil. Muitos se', b'1', 'Escravidão - Volume 2', '0', NULL, '37.70', 'BROCHURA', '23.00', 'Laurentino Gomes', 'Português', '2.8', '512', 'Brasil', '200', '15.6', '1', '3', '1'), 
('LIVRO', NULL, '2021-08-15', b'0', 'Maior território escravista do hemisfério ocidental, o Brasil recebeu cerca de 5 milhões de cativos africanos, 40% do total de 12,5 milhões embarcados para a', b'1', 'Escravidão – Volume 1', '0', NULL, '29.90', 'BROCHURA', '22.86', 'Laurentino Gomes', 'Português', '2.57', '504', 'Brasil', '150', '15.24', '2', '3', '1'),
('PAPELARIA', NULL, '2021-08-15', b'0', 'Caneta Esferográfica Cristal Dura + que proporciona uma escrita macia e durável, até 2Km\r\nPonta média 1,0mm', b'1', 'Caneta Esferográfica 1.0mm Cristal Azul Bic CX 50 UN', '0', NULL, '32.90', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '3', '2', '1');













