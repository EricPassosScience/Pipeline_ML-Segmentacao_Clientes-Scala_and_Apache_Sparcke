// Databricks notebook source
// MAGIC %python
// MAGIC /// Import SparkSession
// MAGIC import org.apache.spark.sql.SparkSession
// MAGIC 
// MAGIC // Definindo o log de erro
// MAGIC import org.apache.log4j._
// MAGIC Logger.getLogger("org").setLevel(Level.ERROR)
// MAGIC 
// MAGIC // Criando sessão Spark
// MAGIC val spark = SparkSession.builder().getOrCreate()
// MAGIC 
// MAGIC // Importando o algoritmo K-Means
// MAGIC import org.apache.spark.ml.clustering.KMeans
// MAGIC 
// MAGIC // Carregando o dataset
// MAGIC val dataset = spark.read.option("header","true").option("inferSchema","true").csv("dbfs:/FileStore/shared_uploads/eric.passos@dataside.com.br/dados-3.csv")
// MAGIC 
// MAGIC // Selecionamos as seguintes colunas para o conjunto de treinamento:
// MAGIC // Fresh, Milk, Grocery, Frozen, Detergents_Paper, Delicatessen
// MAGIC val feature_data = dataset.select($"Fresh", $"Milk", $"Grocery", $"Frozen", $"Detergents_Paper", $"Delicatessen")
// MAGIC println(dataset.schema)
// MAGIC 
// MAGIC // Import VectorAssembler e Vectors
// MAGIC import org.apache.spark.ml.feature.{VectorAssembler,StringIndexer,VectorIndexer,OneHotEncoder}
// MAGIC import org.apache.spark.ml.linalg.Vectors
// MAGIC 
// MAGIC // Criamos um novo objeto VectorAssembler chamado assembler para a coluna de atributos
// MAGIC val assembler = new VectorAssembler().setInputCols(Array("Fresh", "Milk", "Grocery", "Frozen", "Detergents_Paper", "Delicatessen")).setOutputCol("features")
// MAGIC 
// MAGIC // Usamos o objeto assembler para transformar o feature_data
// MAGIC // Chamamos este novo objeto de dataset
// MAGIC val dataset = assembler.transform(feature_data).select("features")
// MAGIC 
// MAGIC // Criando o modelo Kmeans com K = 3
// MAGIC val kmeans = new KMeans().setK(3).setSeed(1L)
// MAGIC 
// MAGIC // Fit do modelo
// MAGIC val model = kmeans.fit(dataset)
// MAGIC 
// MAGIC // Previsões
// MAGIC val previsoes = model.transform(dataset)
// MAGIC 
// MAGIC // Criamos o avaliador de cluster
// MAGIC import org.apache.spark.ml.evaluation.ClusteringEvaluator
// MAGIC val evaluator = new ClusteringEvaluator()
// MAGIC 
// MAGIC // Avaliaremos o modelo usando o Silhouette Score.
// MAGIC // O Silhouette Score é um coeficiente dentro do intervalo [-1, 1]. 
// MAGIC // Valor próximo de 1 significa que os clusters são muito densos e bem separados. 
// MAGIC // Valor próximo de 0 significa que os clusters estão sobrepostos. 
// MAGIC // Valor inferior a 0 significa que os dados pertencentes aos clusters podem estar errados/incorretos.
// MAGIC val silhouette = evaluator.evaluate(previsoes)
// MAGIC println(s"Silhouette Score = $silhouette")
// MAGIC 
// MAGIC // Mostra os resultados
// MAGIC println("Segmentos de Clientes (Clusters): ")
// MAGIC previsoes.collect().foreach(println)
// MAGIC 
// MAGIC // Salva o resultado em disco
// MAGIC // O código a seguir não funciona no Databricks (ambiente que eu uso), mas se executado em sua máquina local, funcionará perfeitamente. 
// MAGIC import java.io._
// MAGIC val writer = new BufferedWriter(new FileWriter("previsoes.txt"))
// MAGIC writer.write("Fresh, Milk, Grocery, Frozen, Detergents_Paper, Delicatessen, Grupo\n")
// MAGIC previsoes.collect().foreach(x=>{writer.write(x.toString())})
// MAGIC writer.close()
