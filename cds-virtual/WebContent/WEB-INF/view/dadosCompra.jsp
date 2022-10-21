<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Loja virtual</title>
  </head>
  <body>
    <h2>Dados de compra:</h2>
    <form name="formDados" action="/cds-virtual/confirmaDados" method="POST">
      <table>
        <tr>
          <td>Nome:</td>
          <td><input type="text" name="nome"></td>
        </tr>
        <tr>
          <td>Endereço de entrega:</td>
          <td><input type="text" name="endereco"></td>
        </tr>
        <tr>
          <td>Número do cartão:</td>
          <td><input type="text" name="cartao"></td>
        </tr>
      </table>
      <input type="submit" value="Enviar dados">
    </form>
  </body>
</html>