# Trabalho Final de FBD (PetShop)

### Este trabalho possui um CRUD simples, abaixo está o script do banco de dados, junto com as Trigger e Procedures

```sql
create table cliente (
	id serial,
	nome varchar(100),
	cpf varchar(12) primary key,
	endereco varchar(150)
);

create table pet (
	id serial primary key,
	nome varchar(100),
	cpf_dono varchar(12),
	idade int,
	especie varchar(100),
	constraint pet_fk foreign key(cpf_dono)
	references cliente(cpf)
);

create table servico (
	id serial primary key,
	nome varchar(100),
	preco float
);

create table venda (
	id serial,
	cpf_cliente varchar(12),
	id_pet int,
	id_servico int,
	constraint venda_pk primary key(cpf_cliente, id_pet, id_servico),
	constraint venda_fk1 foreign key(cpf_cliente)
	references cliente(cpf),
	constraint venda_fk2 foreign key(id_pet)
	references pet(id),
	constraint venda_fk3 foreign key(id_servico)
	references servico(id)
);


create table adicionarPetCliente(
	cpf_cliente varchar(12),
	id_pet int,
	constraint add_pk primary key(cpf_cliente, id_pet),
	constraint add_fk1 foreign key(cpf_cliente)
	references cliente(cpf),
	constraint add_fk2 foreign key(id_pet)
	references pet(id)
);
```

### Trigger e Procedure para deletar um Pet, das tabelas em que são dependentes dele, lembrando que há um comando que o comando _Cascade_ realiza a mesma função das Triggers abaixo.

```sql
create or replace function del_pet_venda_func() returns trigger as $$
	begin
		delete from venda where id_pet = old.id;
		delete from adicionarpetcliente where id_pet = old.id;
		return old;
	end;
$$ language 'plpgsql'

create trigger delelete_pet_venda_trigger
	before delete on pet
		for each row execute procedure del_pet_venda_func()
```

### Trigger e Procedure para deletar um Cliente

```sql
create or replace function del_cliente_pet_func() returns trigger as $$
	begin
		delete from pet where cpf_dono = old.cpf;
		delete from endereco where cpf_cliente = old.cpf;
		return old;
	end;
$$ language 'plpgsql'

create trigger delelete_cliente_pet_trigger
	before delete on cliente
		for each row execute procedure del_cliente_pet_func()

```
### Trigger e Procedure para deletar um Serviço

```sql
create or replace function del_servico_venda_func() returns trigger as $$
	begin
		delete from venda where id_servico = old.id;
		return old;
	end;
$$ language 'plpgsql'

create trigger delelete_servico_venda
	before delete on servico
		for each row execute procedure del_servico_venda_func()

```








