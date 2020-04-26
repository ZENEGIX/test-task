# test-task

ТЗ:

2. Требуется разработать рест сервис с client-side basic авторизацией, принимающий на вход POST-запросы в формате json.
Креденшиалы basic авторизации нужно передать в заголовке "Authorization" POST запроса. На стороне сервера их можно прописать в настроечном файле.

Адрес: http://host:port/app/nbkirequest

Формат тела запроса:
{
"personaldata": {
    "client_name": "Александр",
    "client_surname": "Громыко",
    "client_patronymic": "Александрович",
    "passport_series": "4109",
    "passport_number": "123 456",
    "passport_date_of_issue": "10.10.2010"
  }
}

Берем переданные в запрос данные и формируем XML-сообщение:

<soapenv:Envelope xmlns:soapenv="http://www.w3.org/2003/05/soap-envelope" xmlns:urn="urn:mFlow">
  <soapenv:Header />
 <soapenv:Body>
    <urn:request>
      <correlationId>C3BC97E1-2AE6-468A-B01B-E24659CC95F0</correlationId>
      <payload>
        <first_name>Иван</first_name>
        <last_name>Иванов</last_name>
        <patr_name>Иванович</patr_name>
        <doc_number>123456</doc_number>
        <doc_series>11 22</doc_series>
        <doc_issue_date>22.04.2014</doc_issue_date>
      </payload>
    </urn:request>
  </soapenv:Body>
</soapenv:Envelope>

Ответ сервера:

<soapenv:Envelope xmlns:soapenv="http://www.w3.org/2003/05/soap-envelope" xmlns:urn="urn:mFlow">
  <soapenv:Header />
 <soapenv:Body>
    <urn:request>
      <correlationId>C3BC97E1-2AE6-468A-B01B-E24659CC95F0</correlationId>
      <payload>
        <first_name>Иван</first_name>
        <last_name>Иванов</last_name>
        <patr_name>Иванович</patr_name>
        <doc_number>123456</doc_number>
        <doc_series>11 22</doc_series>
        <doc_issue_date>22.04.2014</doc_issue_date>
      </payload>
    </urn:request>
  </soapenv:Body>
</soapenv:Envelope>

Полученный в XML ответе файл передаем в ответе на вызов рест-сервиса в json формате.

{
  {"file":"base64_encoded_file"}
}

В случае ошибки в поле file передаем значение "error"
