package dijkatra;

/**
 * Created by jingbao on 18-5-18.
 */
public class Dijkatra {
    private MyResource resource;
    private MyProcess []process;
    private int [][] dijkatra;
    public Dijkatra(MyResource resource,MyProcess[] process){
        this.resource=resource;
        this.process=process;
        dijkatra=new int[process.length][resource.getResource()
                .length*3];
    }
    public void init(){
        for(int m=0;m<process.length;m++){
            for(int n=0;n<process[m].getMax().length;n++){
                System.out.println(n+"*****"+process[m]
                        .getMax()[n]);
                dijkatra[m][n]=process[m]
                        .getMax()[n];
                //System.out.println(dijkatra[m][n]);
            }
            for(int n=0;n<process[m].getNeed().length;n++){
                dijkatra[m][n]=process[m]
                        .getNeed()[n];
            }
            for(int n=0;n<process[m].getAllocation().length;n++){
                dijkatra[m][n]=process[m]
                        .getAllocation()[n];
            }



        }
        for(int i=0;i<process.length;i++){
            for(int j=0;j<resource.getResource().length;j++){
                if(j==resource.getResource().length-1){
                    System.out.println(dijkatra[i][j]);
                }else {
                    System.out.print(dijkatra[i][j]+"  ");
                }
            }
        }
    }
    public void allot(MyRequest request){
        int [] requestList=request.getRequest();
        for(int i=0;i<process.length;i++){
            for(int j=0;j<resource.getResource().length;j++){

            }

        }

    }

    public static void main(String[] args) {
        int[] list={10,5,7};
        MyResource resource=new MyResource(list);
        int[] max={3,3,2};
        int [] allocation={0,0,0};
        MyProcess a=new MyProcess(max,max,allocation);
        int[] maxb={5,3,2};
        MyProcess b=new MyProcess(maxb,maxb,allocation);
        MyProcess []myProcess={a,b};
        Dijkatra dijkatra=new Dijkatra(resource,myProcess);
        dijkatra.init();

    }
}
