

<details>
  <summary><h3>User</h3></summary>
  
  ## User

/user

### User tem as Propriedades :

- UserId
- Name
- Pwd (Password, sera crytografada durante o Post do user)
- Email
- BirthDate
- Code (um codigo personalizado pelo usario para confirmar que é ele ao receber o pedido)
- Role (Spring security, podendo ser “admin” , “user”,”delivery”.  )
- Addresses (Lista de endereços do usuario)
- Authorities (Spring security)

### User Metodos

- getAllUsers (Retorna todos os usuarios)
- getUserById (Retorna um usuario apartir do id dele)
- getByName(Retorna uma lista dos usuarios com o nome colocado)
- getByEmail(Retorna um usuario apartir do email)
- postUserAdmin ( Posta um user com role de “admin”)
- postUser ( Posta um user com role de “user”)
- postUserRestaurant ( Posta um user com role de “restaurant”)
- postUserDelivery ( Posta um user com role de “delivery”)
- deleteById (Deleta um usuario pela Id dele)
- editUser (Edita um usuario apartir da Id)
- addAddress (Adiciona um endereço a lista de endereços do usuario apartir do Id dele)
- editAddres (Edita o endereço apartir do Id do usuario seguido pelo Id do endereço)
  
</details>

<details>
  <summary><h3>Restaurant</h3></summary>
  
  ## Restaurant

### Restaurant tem as Propriedades :

- RestaurantId
- Name
- Description
- Itens ( Lista de comidas a venda no restaraunte )
- Address
- restaurantOwner ( User ligado a esse restaurant)

### Restaurant Metodos

- getAll (Retorna todos os restaurantes)
- getById (Retorna um restaurant apartir do id dele)
- postRestaurant ( Posta um restaurant apartir do id de um usario do type restaurnt)
- putRestaurant (Edita um restaurant apartir da Id)
- deleteResturantById (Deleta um restaurant pela Id dele)
- addAddress (Adiciona um endereço do restaurant apartir do Id dele)
- editAddres (Edita o endereço do restaurante)
- aproveDelivery (Quando um usuario faz um pedido, o restaurante precisa aprovar o pedido, para não ocorrer falta de ingredientes ou outras complicaçoes, esse method precisa de o id do restaurant seguido pelo id do delivery)
- inDelivery ( Quando o entregador estiver com o pedido o restaurante teve atulizar o status do pedido,  esse method precisa de o id do restaurant seguido pelo id do delivery

  
</details>


<details>
  <summary><h3>OrderFood</h3></summary>
  ## OrderFood

Essa class serve como um item que ira para o carrinho, contendo uma comida e quantidade dela

### OrderFood tem as Propriedades :

- orderFoodId
- Food
- Quantity

### OrderFood Metodos

- getAll (Retorna todos OrderFood)
- postOrderFood ( Posta um OrderFood)


  
</details>

<details>
  <summary><h3>Order</h3></summary>
  
  ## Order

### Order tem as Propriedades :

- orderId
- user (o usuario que esta fazendo o pedido)
- address ( o endereço de entrega do pedido)
- foodsId (usado na hora de fazer o pedido, para saber quais sao os id da OrderFoods necessario para esse pedido)
- foods (List com OrderFood essa variavel é prenchida apartir do foodsId na hora do post)
- restaurant
- status ( OrderStatus é um enum)
- totalValue( total valor da compra, é prenchido quando se posta uma ordem baseado nos itens pedidos)

  ### Order Metodos

- getAll (Retorna todas as orders)
- getByUser( Retorna todas as orders feitas por um user)
- postOrder ( Posta uma Order, precisa de uma list de ID das orderFood que componhe essa order no request body,tambem precisa do id do usuario que iria fazer o pedido,seguido por addressId,seguido restaurantId)
- deleteOrderById (Deleta uma order pela Id dela)
- paidOrder ( usado para quando o pagamento é confirmado)
  
</details>

<details>
  <summary><h3>Food</h3></summary>
  ## Food

### Food tem as Propriedades :

- FoodId
- Name
- Price
- description
- stock (Opicional, durante a execução do order ele verifica se o stock foi colocado)
- category ( Lista de Categorias, Category é um Enum )
- Restaurant ( Restaurant ligado a essa comida)

### Food Metodos

- getAllFoods (Retorna todas as Comidas)
- getById (Retorna um restaurant apartir do id dele)
- getFoodByName (Retorna uma Lista de comida baseada no nome delas)
- getByCategory ( Retorna uma Lista de comida baseado na categoria delas) ADICIONAR EXCEÇAO
- postFood ( Posta uma Comida)
- putFood (Edita uma Comida apartir da Id)
- deleteById (Deleta uma comida pela Id dela)
  
  
</details>

<details>
  <summary><h3>Delivery Boy</h3></summary>
  
  ## DeliveryBoy

### DeliveryBoy tem as Propriedades :

- Id
- user  (User associado ao deliveryBoy)
- region (regiao que o delivery quer entrar fazer)
- deliveries (Lista de deliverys do entregador)

### DeliveryBoy Metodos

- getAll (Retorna todos os deliverysBoys)
- getById (um DeliveryBoy pela id)
- postDelivery (cirar um deliveryBoy, precisa do id de um usuario)
- deliveryFood ( Sinaliza que o pedido foi entregue, necessita do codigo do usuario)
- ChangeBoyRegion(muda a regiao de entra do entragador)
  
</details>

<details>
  <summary><h3>Delivery</h3></summary>
  
  ## Delivery

Ela é criada quando o pagamento é confirmado ( if the restaurnt dont aprove the money will be send back, in concept)

### Delivery tem as Propriedades :

- Id
- order  (O pedido associado com esse delivery )
- status (O status do delivery que ira aparecer para o cliente)
- selectAddress (automaticamente prenchido quando postado)
- boy (DeliveryBoy associado a esse delivery)

### Delivery Metodos

- getAll (Retorna todos os deliverys)
- getByRegionDelivery ( Retorna os deliverys baseado na regiao do deliveryBoy)
- addDeliveryboy (Liga um deliveryBoy ao delivery)
  
</details>

<details>
  <summary><h3>Addres</h3></summary>
  
## Address

### Address tem as Propriedades :

- id
- state
- typeId
- type
- city
- address(rua)

### Address Metodos

- getAll(retorna todos os endereços)
- deleteAddress(deleta um endereço baseado numa id)
  
</details>
    
    

