# Задание 2.

Реализованно:

Бонус:

# Документация REST API

## Контроллер Товаров:

### 1. Получение всех товаров

    Метод: GET
    Эндпоинт: /api/v1/products
    Получает список всех товаров.

---

### 2. Получение товара по ID

    Метод: GET 
    Эндпоинт: /api/v1/products/{productId}
    Получает товар по его идентификатору.
    productId целое число

---

### 3. Создание товара

    Метод: POST 
    Эндпоинт: /api/v1/products
    Поля description, price, available - опциональные
    Создает новый товар.

Тело запроса (JSON)

```json
{
  "name": "Название товара",
  "description": "Описание товара",
  "price": 10.99,
  "available": true
}
```

---

### 4. Обновление товара по ID

    Метод: PUT 
    Эндпоинт: /api/v1/products/{productId}
    Обновляет существующий товар.
    productId целое число

Тело запроса (JSON)

```json
{
  "name": "Новое название товара",
  "description": "Новое описание товара",
  "price": 12.99,
  "available": false
}
```

---

### 5. Удаление товара по ID

    Метод: DELETE
    Эндпоинт: /api/v1/products/{productId}
    Удаляет товар по его идентификатору.
    productId целое число

---

## Установка и запуск

1. Клонируйте репозиторий.
2. Откройте проект в вашей среде разработки.
3. Запустите класс `Application`.

