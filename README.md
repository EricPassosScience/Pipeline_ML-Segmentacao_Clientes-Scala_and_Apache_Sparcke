# Pipeline de Machine Learning para Segmentação de Clientes com Linguagem Scala e Apache Spark
Nesta ocasião trabalharemos com Linguagem Scala para construir um pipeline de Machine Learning, com o objetivo de realizar a segmentação automática de clientes. Usaremos aprendizado não supervisionado com o Apache Spark. 

### Objetivo
Nossa tarefa será tentar agrupar clientes de uma Rede de Lojas de Varejo, com base nas vendas de algumas categorias de produtos. Para tanto, usaremos o algoritmo KMeans -> https://spark.apache.org/docs/latest/api/scala/org/apache/spark/ml/clustering/KMeans.html

### Fonte de Dados 
-> http://archive.ics.uci.edu/ml/datasets/Wholesale+customers

### Informações sobre os atributos: 
- FRESH: Despesas anuais em produtos frescos (Contínuo);
- MILK: Despesas anuais em produtos lácteos (Contínuo);
- GROCERY: Gastos anuais em produtos de mercearia (Contínuo);
- FROZEN: Despesas anuais em produtos congelados (Contínuo);
- DETERGENTS_PAPER: Gastos anuais em detergentes e produtos de papel (Contínuo);
- DELICATESSEN: Despesas anuais e produtos delicatessen (Contínuo);
- CHANNEL: Canal de clientes - Hotel / Restaurante / Café ou canal de varejo (Nominal);
- REGION: Região Clientes -Lisboa, Porto ou Outros (Nominal).

## ESPAÑOL:

### Pipeline de aprendizaje automático para la segmentación de clientes con Scala Language y Apache Spark
En esta ocasión trabajaremos con Scala Language para construir un pipeline de Machine Learning, con el objetivo de realizar una segmentación automática de clientes. Usaremos el aprendizaje no supervisado con Apache Spark.

### Objetivo
Nuestra tarea será intentar agrupar a los clientes de una Red de Tiendas Minoristas, en base a las ventas de algunas categorías de productos. Para ello, utilizaremos el algoritmo KMeans -> https://spark.apache.org/docs/latest/api/scala/org/apache/spark/ml/clustering/KMeans.html

### Fuente de datos
-> http://archive.ics.uci.edu/ml/datasets/Wholesale+customers

### Información del atributo:
- FRESH: Gasto anual en productos frescos (Continuo);
- MILK: Gasto anual en productos lácteos (Continuo);
- GROCERY: Gasto anual en productos de abarrotes (Continuo);
- FROZEN: Gastos anuales en productos congelados (Continuo);
- DETERGENTS_PAPER: Gasto anual en detergentes y productos de papel (Continuo);
- DELICATESSEN: Gastos anuales y productos delicatessen (Continuo);
- CHANNEL: Canal de clientes - Hotel / Restaurante / Café o canal minorista (Nominal);
- REGION: Región del Cliente -Lisboa, Oporto u Otros (Nominal).
