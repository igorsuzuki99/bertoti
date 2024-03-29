# Igor Suzuki Kira
## Projeto 1: 2º Semestre de 2022
### Parceiro Acadêmico
#### IACIT
![](https://github.com/igorsuzuki99/bertoti/blob/e476dee40e6b64e6f22ca2866eb7b950dc834383/Metodologia/download.png)
### Descrição do Projeto
Desenvolvimento de um sistema no qual seja possível importar, pesquisar e gerar relatórios de dados meteorológicos. Além disso, alocação dos dados disponibilizados no site do Instituto Nacional de Meteorologia (INMET) para um banco de dados, para integrar com o sistema desenvolvido. Aplicação com interface web, que dispõe de um mecanismo de filtro no qual é possível filtrar os registros por datas, regiões, estados, localidades e tipo de dado, para posteriormente expor as informações em formato de gráficos e com a possibilidade de exportar um relatório com base na consulta realizada.

### Tecnologias Utilizadas
![java_spring](https://github.com/igorsuzuki99/bertoti/blob/3bdf06bd363c4a90096a16e0491ab4f8ca127638/Metodologia/javaspring.jpg)
#### Java Spring 
O back-end da aplicação foi desenvolvido predominantemente em Java, uma linguagem orientada a objetos, na qual juntamente com a tecnologia de Spring foi possível criar endpoints para interfaces web.
O Spring é um framework que dispõe de recursos para criação de aplicações web escritas em Java e que traz mais agilidade para o desenvolvimento, visto que facilita as configurações iniciais do projeto com a injeção de dependências, as quais servem tanto para preparar o ambiente, quanto para otimizar a utilização de ferramentas e bibliotecas durante o desenvolvimento do projeto.
<br><br><br>
![potgres_logo](https://github.com/igorsuzuki99/bertoti/blob/15e9c5d7351a579e2e31344f6e97498082a493ca/Metodologia/postgre.jpg)
#### PostgreSQL
O banco de dados utilizado foi o PostgreSQL, um banco relacional no qual alocamos todos os dados meteorológicos, dados de estações e regiões. A escolha do Postgres se deu por conta de sua versatilidade, interface simplificada, e funcionalidades expostas de forma dedutiva, que facilitaram a usabilidade e gerenciamento do banco de dados. A sua alta eficiência e desempenho contribuiram para armazenar com tranquilidade os milhões de dados meteorológicos importados.
<br><br><br>
![chart_logo](https://github.com/igorsuzuki99/bertoti/blob/f15061508c05dbba8a39773679a2937d07c6a00c/Metodologia/chart%20(3).jfif)
#### Chart.js
Chart.js é uma biblioteca do JavaScript que possibilita a exposição de dados em forma de gráficos em páginas web, ela foi essencial para a interface do projeto. Com ela, pudemos mostrar de forma interativa os dados meteorológicos devidamente filtrados e escolhidos pelo usuário da aplicação. Nela também é possível personalizar as propriedades de design, o que possibilitou a exposição de gráficos personalizados de acordo com cada tipo de dado.
<br><br><br>
### Contribuições Individuais
<details>
  <summary><b>Criação e personalização dos endpoints back-end</b></summary>
  <br>
  <p>Nesse projeto realizei o desenvolvimento dos métodos em back-end que realizavam as consultas dos dados meteorológicos no banco de dados. Criei os endpoints principais de consultas gerais, e também os endpoints personalizados baseados nos filtros. De acordo com os filtros selecionados, eu validava os parâmetros recebidos e adaptava os endpoints com consultas personalizadas no banco de dados para retornar os resultados pretendidos.</p>
  
  ```java
  
  @GetMapping(value = "/precipitacao/range/{estacao}/{data1}/{data2}")
    public List<Precipitacao> listarRangePrecipitacao(@PathVariable("estacao") String codigo, @PathVariable("data1") String precData, @PathVariable("data2") String precData1){
        Query query = entityManager.createNativeQuery("select * from precipitacao where prec_data between '"+precData+"' and '"+precData1+"' and fk_estacao_cod_wmo = '"+codigo+"'");
        List<Object[]> rows = query.getResultList();
        List<Precipitacao> list = new ArrayList<>();
        for (Object[] obj : rows) {
            list.add(new Precipitacao(
                    (Integer) obj[0],
                    (Date) obj[1],
                    (Date)obj[2],
                    (BigDecimal) obj[3],
                    (String) obj[4])
            );
        }
        return list;
    }
  
  ```
  
  <p><i>No exemplo de código acima, o endpoint de precipitação recebe os parâmetros personalizados de acordo com a estação e datas escolhidas pelo usuário, realiza a pesquisa no banco de dados com as variáveis e coloca o resultado dentro de uma lista de arrays de objetos. Através de um laço, cada objeto do tipo precipitação retornado pela consulta na query é adicionado na lista.</i></p>
  <br>
</details>
<details>
  <summary><b>Desenvolvimento do dashboard</b></summary>
  <br>
  <p>Contribuí no desenvolvimento da interface do front-end, onde implementei a utilização da biblioteca chart.js para construir os gráficos baseados nos dados meteorológicos requisitados. Realizei métodos em JavaScript, que consultavam os JSON's dos endpoints do back-end, e gerava os gráficos a partir dos dados captados. Também implementei inputs na página web para receber os critérios de filtragem e passar os parâmetros para o back-end realizar as consultas.</p>
  
  ```javascript
  
  if(dado[0]=="temperatura"){
    $(document).ready(function(){
        $.getJSON("/temperatura/range/"+dado[1]+"/"+dado[2]+"/"+dado[3],function(data){
          if(dado[1]!=null){
              document.getElementById("selectRegiao").innerHTML = "";
              $("#selectRegiao").append(inventory.find(procurarEstacao).nome_estacao+" - |"+dado[1]+"|");
              document.getElementById("selectEstado").innerHTML = "";
              $("#selectEstado").append(inventory.find(procurarEstacao).estado);
              $(document).ready(function(){
                  $.getJSON("/estados",function(regiao){
                     function procurarEstado(estado) {
                       return estado.nome_estado === inventory.find(procurarEstacao).estado;
                     }
                     document.getElementById("selectRegiao").innerHTML = "";
                     $("#selectRegiao").append(regiao.find(procurarEstado).regiao);
                  });
              });
          }
  ...
  ```
  
  <p><i>No trecho de código acima se o usuário busca pelo dado de temperatura, é realizado uma busca do JSON do endpoint formado pela URL personalizada de acordo com os parâmetros passados de região, estado e estação.</i></p>
  <br>
</details>
<details>
  <summary><b>Geração de relatório</b></summary>
  <br>
  <p>Implementei a função de gerar um PDF do gráfico gerado, contendo as informações meteorológicas filtradas de acordo com a pesquisa do usuário. O pdf gerado contém os dados pesquisados e o gráfico equivalente</p>
</details>


### Aprendizados Efetivos
<details>
  <summary>Spring Framework</summary>
  <br>
    <ul>
      <li>Desenvolvimento de aplicações web</li>
      <li>Arquitetura REST</li>
      <li>Integração com banco de dados</li>
      <li>Injeção de dependências</li>
      <li>Desenvolvimento de código através de interfaces</li>
    </ul>
  <br>
</details>
<details>
  <summary>Banco de dados</summary>
  <br>
    <ul>
      <li>Consultas personalizadas com SQL</li>
      <li>Geração de scripts</li>
      <li>Export e import de backup</li>
    </ul>
  <br>
</details>
<details>
  <summary>Programação</summary>
  <br>
    <ul>
      <li>Funções em JavaScript</li>
      <li>Manipulação de variáveis com JavaScript</li>
      <li>Programação orientada a objetos</li>
      <li>Consumo de API Rest</li>
      <li>Gerenciamento de usuários</li>
      <li>Consumo de recursos de bootstrap</li>
    </ul>
  <br>
</details>
