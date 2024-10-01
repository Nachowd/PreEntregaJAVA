CREATE TABLE Cliente {
    numeroCliente int autoincrement PRIMARY KEY;
    nombre varchar(20) not null;
    apellido varchar(20) not null;
    dni int not null;

}

CREATE TABLE Producto {
    idProducto int autoincrement PRIMARY KEY;
    nombre varchar(20) not null;
    precio real(20) not null;
    cantidad int not null;
    id_cliente int FOREIGN KEY(numeroCliente);

}

CREATE TABLE Pedido {
    nroPedido int not null;
    fecha date not null;
    id_pedido int FOREIGN KEY(numeroCliente);
}