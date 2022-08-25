# Flatfair Coding Challenge

## To start the Django REST API project locally

1. Create a venv and install the repository requirements:

```sh
python3 -m venv venv
source venv/bin/enable
pip3 install django
pip3 install djangorestframework
```

2. Run django migrations:

```
python3 manage.py makemigrations
python3 manage.py migrate
```

3. Start django server:

```
python3 manage.py runserver
```


### How to use the API:

use the endpoint ```http://127.0.0.1:8000/units//``` to add units (POST) and consult all units already created (GET)

use the endpoint ```http://127.0.0.1:8000/units//{id_unit}:{rent_amount}:{rent_period}``` to calculate the fee for a unit (GET)

Development by Pedro Henrique Falleiros Sampaio Presotto

---

# Desafio Flatfair

## Para iniciar o Django REST API localmente

1. Crie uma venv e instale os requisitos fora do repositorio:

```
python3 -m venv venv
source venv/bin/activate
pip3 install django
pip3 install djangorestframework
```

2. Rode as migrações do django:

```
python3 manage.py makemigrations
python3 manage.py migrate
```


3. Inicie o server localmente:

```
python3 manage.py runserver
```

### Como usar a API:

acesse ```http://127.0.0.1:8000/units//``` para adicionar unidades (POST) e consultar todas as unidades já criadas (GET)

acesse ```http://127.0.0.1:8000/units//{id_unit}:{rent_amount}:{rent_period}``` para calcular o aluguel de uma unidade (GET)

Desenvolvimento por Pedro Henrique Falleiros Sampaio Presotto
