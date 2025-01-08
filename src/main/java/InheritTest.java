public class InheritTest {

    public static void main(String[] args)
    {
        ChildTest test = new ChildTest();
        //ParentTest parentTest = new ParentTest();
        System.out.println(test.b);
        System.out.println(test.a);
        test.display();
        test.show();

    }

}
