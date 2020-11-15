import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by c_chenyaru on 2020/10/23.
 */
public class DataStructureDemoMain {
    public static void main(String[] args) {
        DataStructureDemoMain structureDemoMain = new DataStructureDemoMain();
        structureDemoMain.chainListStructureTest();
       /* ChainListDto chainListDto = new ChainListDto();
        chainListDto.setName("test");
        Class cl = chainListDto.getClass();
        Field f;
        f = cl.getDeclaredField("name");
        f.setAccessible(true);
        Object obj = f.get(chainListDto);*/
        /*ArrayList<Integer> squens = new ArrayList<>();
        for(int i = 0; i <= 5; i++){
            squens.add(i * i);
            System.out.println(new ObjectAnalyzerTest().toString(squens));

        }*/

    }

    /**
    *数据结构-链表
    *@return {@link }
    *@throws
    *@author chenyaru
    *@date  2020-10-23
    */
    private void chainListStructureTest(){
        ChainListDto chainListDto;
        ChainListType node;

        ChainListType head = null;//头节点
        ChainListType tail = null;//尾节点
        //初始化链表并在结尾追加节点
        for (int i = 0; i < 5; i++) {
            //新增节点并初始化
            node = new ChainListType();
            chainListDto = innitData(i);
            node.setChainListDto(chainListDto);
            //在链表结尾追加节点
            if(head == null) {
                head = addNodeAtEnd(head,node);
            } else {
                tail = addNodeAtEnd(head,node);
            }
        }
        System.out.println("在链表结尾追加节点成功");
        //遍历所有节点
        queryChainList(head);
        //在链表中间某位置增加新节点
        //初始化新节点
        node = new ChainListType();
        chainListDto = innitData(6);
        node.setChainListDto(chainListDto);
        String isUpdate = updateNode(head,node,"element2");
        System.out.println("由插入位置前一节点指向下一节点的Key-" + isUpdate);
        //遍历插入后所有节点
        queryChainList(head);
        //删除某位置的节点
        node = new ChainListType();
        String isDel = delNode(head,"element6");
        System.out.println(isDel);
        queryChainList(head);
    }

    private String delNode(ChainListType head, String element6) {
        String isDel = "";
        ChainListType tempNode;
        while(head != null){
            tempNode = head.getNextNode();
            if(tempNode.getChainListDto().getKey().equals(element6)){
                head.setNextNode(tempNode.getNextNode());
                isDel = "要删除节点的前一节点Key-" + head.getChainListDto().getKey();
                break;
            }
            head = head.getNextNode();
        }
        if(isDel.equals("")){
            isDel = "不存在要删除的目标节点";
        }
        return isDel;
    }

    private void queryChainList(ChainListType head) {
        int index = 0;
        while(head != null){
            index++;
            ChainListDto dtoTemp = head.getChainListDto();
            System.out.println("Element" + index + "：key-" + dtoTemp.getKey() + "name-" + dtoTemp.getName() + "age-" + dtoTemp.getAge());
            head = head.getNextNode();
        }
    }

    private String updateNode(ChainListType head,ChainListType node,String key) {
        String result = "";
        if(head == null){
            head = node;
        }
        //找到要插入位置的前一节点
        while(head != null){
            if(head.getChainListDto().getKey().equals(key)){
                node.setNextNode(head.getNextNode());
                head.setNextNode(node);
                result = head.getNextNode().getChainListDto().getKey();
                break;
            }
            head = head.getNextNode();
        }
        return result;
    }

    private ChainListType addNodeAtEnd(ChainListType head, ChainListType node) {
        ChainListType tempNode = null;
        if(node ==null || node.getChainListDto() == null){
            System.out.println("新增节点node未初始化");
        }
        if(head == null){
            head = node;
            return head;
        }
        while(head != null){
            tempNode = head;//保留当前节点
            head = head.getNextNode();//保留当前节点的下一节点
        }
        tempNode.setNextNode(node);//在最后节点追加新节点node
        return tempNode.getNextNode();//返回头结点
    }

    public ChainListDto innitData(int i){
        ChainListDto chainListDto = new ChainListDto();
        chainListDto.setKey("element" + i);
        chainListDto.setName("ZhangSan");
        chainListDto.setAge(10);
        return chainListDto;
    }
}
