package stepDefinition;

import java.io.File;
import java.io.FileFilter;

public class TestCatalog {

    private String catalogFile;
    private File o_catalog;

    public TestCatalog(){
        this(System.getProperty("user.dir") + "/src/main/resources");
    }

    public TestCatalog(String catalogFile){
        this.catalogFile = catalogFile;
        o_catalog = new File(catalogFile);
    }

    public File[] fileListXLSX() {
        //listFiles возвращает массив файлов (обЪектов) с заданным фильтром
        return o_catalog.listFiles(new TestCatalog.ExtFilter("xlsx"));
    }

    //FileFilter  специальный фильтр-класс, который описывает критерии отбора объектов File с помощью интерфейса FileFilter .
    //Интерфейс FilenameFilter определяет единственный метод accept(), вызываемый по одному разу с каждым файлом в списке.
    static class ExtFilter implements FileFilter {
        String ext;

        ExtFilter(String ext) {
            this.ext = ext;
        }

        @Override //переопределяем метод accept
        public boolean accept(File pathname) {
            //определить расширение файла
            String extension = getExtension(pathname);
            //сравнить расширение с нужным расширением
            return extension.equals(ext);
        }

        private String getExtension(File pathname) {
            //getPath Метод возвращает путь от корня сайта к зарегистрированному файлу
            String filename = pathname.getPath();
            //lastIndexOf возвращает индекс последнего вхождения указанного значения в строковый объект String
            int i = filename.lastIndexOf('.');
            //если i>0 и i <последнего знака
            if (i > 0 && i < filename.length() - 1) {
                //вернуть часть имени от следущего после точки значения до конца
                //substring возвращает подстроку строки между двумя индексами
                //toLowerCase возвращает значение строки, на которой он был вызван, преобразованное в нижний регистр
                return filename.substring(i + 1).toLowerCase();
            }
            return "";
        }
    }

}
