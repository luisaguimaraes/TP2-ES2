import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class teste1 {

    private WebDriver driver;
    private String url;

    @BeforeMethod
    public void before(){

        String caminhoDriver =  "C:\\driver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", caminhoDriver);//instancia do driver
        driver = new ChromeDriver(); //instancia do navegador



    }


    @Test
    public void trabalhoeng() throws InterruptedException {
        driver.get(System.getProperty("user.dir")+"/src/paginas/componentes.html");
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Luisa");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Guimaraes");
        driver.findElement(By.id("elementosForm:sexo:1")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:1")).click();
        Select listaescolaridade = new Select(driver.findElement(By.id("elementosForm:escolaridade")));
        listaescolaridade.selectByVisibleText("Doutorado");
        Select esporte = new Select(driver.findElement((By.id("elementosForm:esportes"))));
        esporte.selectByVisibleText("Natacao");
        driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste teste");
        driver.findElement(By.xpath("//*[@id=\"elementosForm:tableUsuarios\"]/tbody/tr[2]/td[4]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"elementosForm:tableUsuarios\"]/tbody/tr[3]/td[5]/table/tbody/tr/td/input")).click();
        driver.findElement(By.xpath("//*[@id=\"elementosForm:tableUsuarios\"]/tbody/tr[5]/td[6]/input")).sendKeys("escrever");
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        String cadastrado = driver.findElement(By.xpath("//*[@id=\"resultado\"]/span")).getText();
        Assert.assertEquals(cadastrado,"Cadastrado!");
        String nome = driver.findElement(By.xpath("//*[@id=\"descNome\"]/span")).getText();
        Assert.assertEquals(nome, "Luisa");
        String sobrenome = driver.findElement(By.xpath("//*[@id=\"descSobrenome\"]/span")).getText();
        Assert.assertEquals(sobrenome, "Guimaraes");
        String sexo = driver.findElement(By.xpath("//*[@id=\"descSexo\"]/span")).getText();
        Assert.assertEquals(sexo, "Feminino");
        String comida = driver.findElement(By.xpath("//*[@id=\"descComida\"]/span")).getText();
        Assert.assertEquals(comida, "Carne Frango");
        String escolaridade = driver.findElement(By.xpath("//*[@id=\"descEscolaridade\"]/span")).getText();
        Assert.assertEquals(escolaridade, "doutorado");
        String esportes = driver.findElement(By.xpath("//*[@id=\"descEsportes\"]/span")).getText();
        Assert.assertEquals(esportes, "Natacao");
        String sugestao = driver.findElement(By.xpath("//*[@id=\"descSugestoes\"]/span")).getText();
        Assert.assertEquals(sugestao, "teste teste");
    }





    @AfterMethod
    public void after(){
        System.out.println("After");
    }
}
