Este repositório contém um aplicativo simples de entrega de comida em Spring Boot. Você precisará de um banco de dados MySQL chamado "fooddb" para trabalhar.

- [User](#user)
- [Restaurant](#restaurant)
- [OrderFood](#orderFood)
- [Order](#order)
- [Food](#food)
- [DeliveryBoy](#delivery-boy)
- [Delivery](#delivery)
- [Address](#address)
- [Postman collection](Food Delivery app.postman_collection.json)

<h1 id="user">Usuário</h1>
http://localhost:8080/user/
<h2>Propriedades do Usuário:</h2>
<ul>
  <li>UserId</li>
  <li>Pwd (Senha, será criptografada durante o envio do usuário)</li>
  <li>Email</li>
  <li>Data de Nascimento</li>
  <li>Código (um código personalizado pelo usuário para confirmar sua identidade ao receber uma solicitação)</li>
  <li>Role (Spring security, pode ser "admin", "user" ou "delivery")</li>
  <li>Endereços (Lista de endereços do usuário)</li>
  <li>Autoridades (Spring security)</li>
</ul>
<p><a href="https://github.com/ThiagoDambroski/foodDeliveryProjectBackEnd/blob/main/src/main/java/com/dambroski/foodDeliveryProject/User/User.java">User.Class</a></p>
<h2>Métodos do Usuário:</h2>
<table>
  <tr>
    <th>Método</th>
    <th>URL</th>
    <th>Descrição</th>
  </tr>
  <tr>
    <td>Obter Todos os Usuários</td>
    <td>/getAll</td>
    <td>Retorna todos os usuários</td>
  </tr>
  <tr>
    <td>Obter Usuário por Id</td>
    <td>/getById/:userId</td>
    <td>Retorna um usuário com base em seu ID</td>
  </tr>
  <tr>
    <td>Obter Usuário por Nome</td>
    <td>/getByName/:name</td>
    <td>Retorna uma lista de usuários com base em seu nome</td>
  </tr>
  <tr>
    <td>Obter Usuário por Email</td>
    <td>/getByEmail/:email</td>
    <td>Retorna um usuário com o email especificado</td>
  </tr>
  <tr>
    <td>Post Usuário Admin</td>
    <td>/post/admin</td>
    <td>Cadastra um novo usuário com a função de "admin"</td>
  </tr>
  <tr>
    <td>Post Usuário</td>
    <td>/post/user</td>
    <td>Cadastra um novo usuário com a função de "user"</td>
  </tr>
  <tr>
    <td>Post Usuário Restaurante</td>
    <td>/post/restaurant</td>
    <td>Cadastra um novo usuário com a função de "restaurant"</td>
  </tr>
  <tr>
    <td>Post Usuário Entregador</td>
    <td>post/delivery</td>
    <td>Cadastra um novo usuário com a função de "delivery"</td>
  </tr>
  <tr>
    <td>Editar Usuário</td>
    <td>/edit/:userId</td>
    <td>Edita um usuário com base em seu ID</td>
  </tr>
  <tr>
    <td>Excluir Usuário por Id</td>
    <td>/delete/:userId</td>
    <td>Exclui um usuário com base em seu ID</td>
  </tr>
  <tr>
    <td>Adicionar Endereço</td>
    <td>/addAddress/:userId</td>
    <td>Adiciona um endereço à lista de endereços do usuário (o endereço deve ser passado no corpo da requisição)</td>
  </tr>
  <tr>
    <td>Editar Endereço</td>
    <td>/editAddress/:userId/:addressId</td>
    <td>Edita um endereço com base em seu ID</td>
  </tr>
</table>
<p><a href="https://github.com/ThiagoDambroski/foodDeliveryProjectBackEnd/blob/main/src/main/java/com/dambroski/foodDeliveryProject/User/UserServiceImpl.java">UserServiceImpl.class</a></p>
<h1 id="restaurant">Restaurante</h1>
http://localhost:8080/restaurant
<h2>Propriedades do Restaurante:</h2>
<ul>
  <li>RestaurantId</li>
  <li>Nome</li>
  <li>Descrição</li>
  <li>Itens (Lista de comidas)</li>
  <li>Endereço</li>
  <li>RestaurantOwner (Classe Usuário)</li>
</ul>
<p><a href="https://github.com/ThiagoDambroski/foodDeliveryProjectBackEnd/blob/main/src/main/java/com/dambroski/foodDeliveryProject/restaurant/Restaurant.java">Restaurant.class</a></p>
<h2>Métodos do Restaurante:</h2>
<table>
  <tr>
    <th>Método</th>
    <th>URL</th>
    <th>Descrição</th>
  </tr>
  <tr>
    <td>Obter Todos os Restaurantes</td>
    <td>/getAll</td>
    <td>Retorna todos os restaurantes</td>
  </tr>
  <tr>
    <td>Obter Restaurante por Id</td>
    <td>/getById/:restaurantId</td>
    <td>Retorna um restaurante com base em seu ID</td>
  </tr>
  <tr>
    <td>Cadastrar Restaurante</td>
    <td>/post/:userId</td>
    <td>Cadastra um restaurante a partir do ID de usuário</td>
  </tr>
  <tr>
    <td>Editar Restaurante</td>
    <td>/put/:restaurantId</td>
    <td>Edita um restaurante com base em seu ID</td>
  </tr>
  <tr>
    <td>Excluir Restaurante por Id</td>
    <td>/delete/:restaurantId</td>
    <td>Exclui um restaurante com base em seu ID</td>
  </tr>
  <tr>
    <td>Editar Endereço por Id</td>
    <td>/restaurant/edit/address/:restaurantId</td>
    <td>Edita um endereço com base no ID do restaurante</td>
  </tr>
  <tr>
    <td>Adicionar um Endereço ao Restaurante</td>
    <td>/addAddress/:restaurantId</td>
    <td>Adiciona um endereço a um restaurante com base em seu ID</td>
  </tr>
  <tr>
    <td>Aprovar Entrega</td>
    <td>/approveDelivery/:restaurantId/:deliveryId</td>
    <td>Quando um usuário faz um pedido, o restaurante precisa aprovar a solicitação para evitar falta de ingredientes ou outras complicações. Este método requer o ID do restaurante seguido pelo ID da entrega. Também define o status como COOKING</td>
  </tr>
  <tr>
    <td>Definir Status de Entrega como Em Entrega</td>
    <td>/restaurant/inDelivery/:restaurantId/:deliveryId</td>
    <td>Quando o entregador possui o pedido, o restaurante deve atualizar o status do pedido. Este método requer o ID do restaurante seguido pelo ID da entrega</td>
  </tr>
</table>
<p><a href="https://github.com/ThiagoDambroski/Spring-Boot-Project/blob/main/src/main/java/com/dambroski/webStoreProject/Itens/ItemServiceimpl.java">ItemServiceImpl.class</a></p>
<h1 id="orderFood">Pedido de Comida</h1>
http://localhost:8080/orderFood
Essa classe serve como um item que irá para o carrinho de compras, contendo um item de comida e sua quantidade.
<h2>Propriedades do Pedido de Comida:</h2>
<ul>
  <li>orderFoodId</li>
  <li>Comida</li>
  <li>Quantidade</li>
</ul>
<p><a href="https://github.com/ThiagoDambroski/foodDeliveryProjectBackEnd/blob/main/src/main/java/com/dambroski/foodDeliveryProject/orderFood/OrderFood.java">OrderFood.class</a></p>
<h2>Métodos do Pedido de Comida:</h2>
<table>
  <tr>
    <th>Método</th>
    <th>URL</th>
    <th>Descrição</th>
  </tr>
  <tr>
    <td>Obter Todos os Pedidos de Comida</td>
    <td>/getAll</td>
    <td>Retorna todos os pedidos de comida</td>
  </tr>
  <tr>
    <td>Cadastrar Pedido de Comida</td>
    <td>/post/:foodId</td>
    <td>Cadastra um pedido de comida</td>
  </tr>
</table>
<p><a href="https://github.com/ThiagoDambroski/foodDeliveryProjectBackEnd/blob/main/src/main/java/com/dambroski/foodDeliveryProject/orderFood/OrderFoodServiceImpl.java">OrderFoodServiceImpl.class</a></p>
<h1 id="order">Pedido</h1>
http://localhost:8080/order
<h2>Propriedades do Pedido:</h2>
<ul>
  <li>orderId</li>
  <li>user (o usuário que está fazendo o pedido)</li>
  <li>endereço (Endereço para entrega do pedido)</li>
  <li>foodsId (Usado no momento de fazer um pedido, para saber quais são os IDs dos Pedido de Comida necessários para este pedido)</li>
  <li>foods (Lista com Pedido de Comida, esta variável é preenchida com base nos foodsId no momento da solicitação POST)</li>
  <li>restaurante</li>
  <li>status (Enum com os valores PAID, IN_PROCESS e CANCELLED)</li>
  <li>valorTotal (O valor total da compra é preenchido quando um pedido é feito, com base nos itens solicitados)</li>
</ul>
<p><a href="https://github.com/ThiagoDambroski/foodDeliveryProjectBackEnd/blob/main/src/main/java/com/dambroski/foodDeliveryProject/order/Order.java">Order.class</a></p>
<h2>Métodos do Pedido:</h2>
<table>
  <tr>
    <th>Método</th>
    <th>URL</th>
    <th>Descrição</th>
  </tr>
  <tr>
    <td>Obter Todos os Pedidos</td>
    <td>/getAll</td>
    <td>Retorna todos os pedidos</td>
  </tr>
  <tr>
    <td>Obter Pedidos por Usuário</td>
    <td>/getByUser/:userId</td>
    <td>Retorna todos os pedidos feitos pelo usuário</td>
  </tr>
  <tr>
    <td>Cadastrar Pedido</td>
    <td>/post/:userId/:addressId/:restaurantId</td>
    <td>Para fazer um pedido, você precisa de uma lista de IDs de Pedido de Comida que compõem este pedido no corpo da solicitação. Além disso, você também precisa do ID do usuário que está fazendo o pedido, seguido pelo ID do endereço para onde o pedido será entregue e, finalmente, o ID do restaurante de onde o pedido está sendo feito</td>
  </tr>
  <tr>
    <td>Excluir Pedido por Id</td>
    <td>/delete/:orderId</td>
    <td>Exclui um pedido com base em seu ID</td>
  </tr>
  <tr>
    <td>Pedido Pago por Id</td>
    <td>/paidOrder/:orderId</td>
    <td>Altera o status de um pedido para PAID</td>
  </tr>
</table>
<p><a href="https://github.com/ThiagoDambroski/foodDeliveryProjectBackEnd/blob/main/src/main/java/com/dambroski/foodDeliveryProject/order/OrderServiceImpl.java">OrderServiceImpl.class</a></p>
<h1 id="food">Comida</h1>
http://localhost:8080/food
<h2>Propriedades da Comida:</h2>
<ul>
  <li>foodId</li>
  <li>Nome</li>
  <li>Preço</li>
  <li>Descrição</li>
  <li>Estoque (Opcional)</li>
  <li>Categoria (Enum)</li>
  <li>Restaurante</li>
</ul>
<p><a href="https://github.com/ThiagoDambroski/foodDeliveryProjectBackEnd/blob/main/src/main/java/com/dambroski/foodDeliveryProject/food/Food.java">Food.class</a></p>
<h2>Métodos da Comida:</h2>
<table>
  <tr>
    <th>Método</th>
    <th>URL</th>
    <th>Descrição</th>
  </tr>
  <tr>
    <td>Obter Todas as Comidas</td>
    <td>/getAll</td>
    <td>Retorna todas as comidas</td>
  </tr>
  <tr>
    <td>Obter Comida por Id</td>
    <td>/getById/:foodId</td>
    <td>Retorna uma comida com base em seu ID</td>
  </tr>
  <tr>
    <td>Obter Comidas por Nome</td>
    <td>/getByName/:name</td>
    <td>Retorna uma lista de comidas com base em seu nome</td>
  </tr>
  <tr>
    <td>Obter Comidas por Categoria</td>
    <td>/getByCategory/:category</td>
    <td>Retorna uma lista de comidas com base em sua categoria</td>
  </tr>
  <tr>
    <td>Cadastrar Comida</td>
    <td>/post/:restaurantId</td>
    <td>Cadastra uma comida para um restaurante</td>
  </tr>
  <tr>
    <td>Editar Comida</td>
    <td>/put/:foodId</td>
    <td>Edita uma comida com base em seu ID</td>
  </tr>
  <tr>
    <td>Excluir Comida por Id</td>
    <td>/delete/:foodId</td>
    <td>Exclui uma comida com base em seu ID</td>
  </tr>
</table>
<p><a href="https://github.com/ThiagoDambroski/foodDeliveryProjectBackEnd/blob/main/src/main/java/com/dambroski/foodDeliveryProject/food/FoodServiceImpl.java">FoodServiceImpl.class</a></p>
<h1 id="delivery-boy">Entregador</h1>
http://localhost:8080/deliveryBoy
<h2>Propriedades do Entregador:</h2>
<ul>
  <li>Id</li>
  <li>Usuário (Usuário associado ao entregador)</li>
  <li>Região (A região onde o entregador deseja fazer entregas)</li>
  <li>Entregas (Lista de entregas feitas pelo entregador)</li>
</ul>
<p><a href="https://github.com/ThiagoDambroski/foodDeliveryProjectBackEnd/blob/main/src/main/java/com/dambroski/foodDeliveryProject/deliveryBoy/DeliveryBoy.java">DeliveryBoy.class</a></p>
<h2>Métodos do Entregador:</h2>
<table>
  <tr>
    <th>Método</th>
    <th>URL</th>
    <th>Descrição</th>
  </tr>
  <tr>
    <td>Obter Todos os Entregadores</td>
    <td>/getAll</td>
    <td>Retorna todos os entregadores</td>
  </tr>
  <tr>
    <td>Obter Entregador por Id</td>
    <td>/getById/:boyId</td>
    <td>Retorna um entregador com base em seu ID</td>
  </tr>
  <tr>
    <td>Cadastrar Entregador</td>
    <td>/post/:userId</td>
    <td>Cadastra um entregador a partir do ID de um usuário</td>
  </tr>
  <tr>
    <td>Entrega de Pedido</td>
    <td>/deliveryAOrder/:deliveryId/:deliveryBoyId/:code</td>
    <td>Indica que o pedido foi entregue, requer o ID da entrega, o ID do entregador e o código do usuário</td>
  </tr>
  <tr>
    <td>Alterar Região do Entregador</td>
    <td>/changeBoyRegion/:boyId</td>
    <td>Altera a região de entrega para um entregador, a nova região é passada no corpo da solicitação</td>
  </tr>
</table>
<p><a href="https://github.com/ThiagoDambroski/foodDeliveryProjectBackEnd/blob/main/src/main/java/com/dambroski/foodDeliveryProject/deliveryBoy/DeliveryBoyServiceImpl.java">DeliveryBoyServiceImpl.class</a></p>
<h1 id="delivery">Entrega</h1>
http://localhost:8080/delivery
<p>Esta classe é criada quando o método Pedido Pago é chamado</p>
<h2>Propriedades da Entrega:</h2>
<ul>
  <li>Id</li>
  <li>Pedido (Pedido associado à entrega)</li>
  <li>Status (Enum com os valores DELIVERY, COOKING, IN_DELIVERY e WAITING_FOR_RESTAURANT_APPROVE)</li>
  <li>Endereço de Entrega (É preenchido automaticamente quando a entrega é cadastrada)</li>
  <li>Entregador (Entregador)</li>
</ul>
<p><a href="https://github.com/ThiagoDambroski/foodDeliveryProjectBackEnd/blob/main/src/main/java/com/dambroski/foodDeliveryProject/delivery/Delivery.java">Delivery.class</a></p>
<h2>Métodos da Entrega:</h2>
<table>
  <tr>
    <th>Método</th>
    <th>URL</th>
    <th>Descrição</th>
  </tr>
  <tr>
    <td>Obter Todas as Entregas</td>
    <td>/getAll</td>
    <td>Retorna todas as entregas</td>
  </tr>
  <tr>
    <td>Obter Entregas por Região do Entregador</td>
    <td>/getByRegionDeliveryBoy/:boyId</td>
    <td>Retorna entregas com base na região do entregador</td>
  </tr>
  <tr>
    <td>Adicionar Entregador a uma Entrega</td>
    <td>/addDeliveryBoy/:deliveryId/:deliveryboyId</td>
    <td>Vincula um entregador a uma entrega</td>
  </tr>
</table>
<p><a href="https://github.com/ThiagoDambroski/foodDeliveryProjectBackEnd/blob/main/src/main/java/com/dambroski/foodDeliveryProject/delivery/DeliveryServiceImpl.java">DeliveryServiceImpl.class</a></p>
<h1 id="address">Endereço</h1>
http://localhost:8080/address
<h2>Propriedades do Endereço:</h2>
<ul>
  <li>Id</li>
  <li>Estado</li>
  <li>IdTipo (ID do usuário vinculado a este endereço)</li>
  <li>Tipo (É preenchido automaticamente quando o endereço é cadastrado, pode ser USUÁRIO ou RESTAURANTE)</li>
  <li>Cidade</li>
  <li>Endereço (Rua)</li>
</ul>
<p><a href="https://github.com/ThiagoDambroski/foodDeliveryProjectBackEnd/blob/main/src/main/java/com/dambroski/foodDeliveryProject/Address/Address.java">Address.class</a></p>
<h2>Métodos do Endereço:</h2>
<table>
  <tr>
    <th>Método</th>
    <th>URL</th>
    <th>Descrição</th>
  </tr>
  <tr>
    <td>Obter Todos os Endereços</td>
    <td>/getAll</td>
    <td>Retorna todos os endereços</td>
  </tr>
  <tr>
    <td>Obter Endereço por Id</td>
    <td>/getById/:addressId</td>
    <td>Retorna um endereço com base em seu ID</td>
  </tr>
  <tr>
    <td>Obter Endereços por Tipo</td>
    <td>/getByType/:type</td>
    <td>Retorna uma lista de endereços com base em seu tipo (USUÁRIO ou RESTAURANTE)</td>
  </tr>
  <tr>
    <td>Cadastrar Endereço</td>
    <td>/post/:userId/:type</td>
    <td>Cadastra um endereço para um usuário ou restaurante</td>
  </tr>
  <tr>
    <td>Editar Endereço</td>
    <td>/put/:addressId</td>
    <td>Edita um endereço com base em seu ID</td>
  </tr>
  <tr>
    <td>Excluir Endereço por Id</td>
    <td>/delete/:addressId</td>
    <td>Exclui um endereço com base em seu ID</td>
  </tr>
</table>
<p><a href="https://github.com/ThiagoDambroski/foodDeliveryProjectBackEnd/blob/main/src/main/java/com/dambroski/foodDeliveryProject/Address/AddressServiceImpl.java">AddressServiceImpl.class</a></p>