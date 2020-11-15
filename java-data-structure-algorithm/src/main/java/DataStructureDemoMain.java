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
    *���ݽṹ-����
    *@return {@link }
    *@throws
    *@author chenyaru
    *@date  2020-10-23
    */
    private void chainListStructureTest(){
        ChainListDto chainListDto;
        ChainListType node;

        ChainListType head = null;//ͷ�ڵ�
        ChainListType tail = null;//β�ڵ�
        //��ʼ�������ڽ�β׷�ӽڵ�
        for (int i = 0; i < 5; i++) {
            //�����ڵ㲢��ʼ��
            node = new ChainListType();
            chainListDto = innitData(i);
            node.setChainListDto(chainListDto);
            //�������β׷�ӽڵ�
            if(head == null) {
                head = addNodeAtEnd(head,node);
            } else {
                tail = addNodeAtEnd(head,node);
            }
        }
        System.out.println("�������β׷�ӽڵ�ɹ�");
        //�������нڵ�
        queryChainList(head);
        //�������м�ĳλ�������½ڵ�
        //��ʼ���½ڵ�
        node = new ChainListType();
        chainListDto = innitData(6);
        node.setChainListDto(chainListDto);
        String isUpdate = updateNode(head,node,"element2");
        System.out.println("�ɲ���λ��ǰһ�ڵ�ָ����һ�ڵ��Key-" + isUpdate);
        //������������нڵ�
        queryChainList(head);
        //ɾ��ĳλ�õĽڵ�
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
                isDel = "Ҫɾ���ڵ��ǰһ�ڵ�Key-" + head.getChainListDto().getKey();
                break;
            }
            head = head.getNextNode();
        }
        if(isDel.equals("")){
            isDel = "������Ҫɾ����Ŀ��ڵ�";
        }
        return isDel;
    }

    private void queryChainList(ChainListType head) {
        int index = 0;
        while(head != null){
            index++;
            ChainListDto dtoTemp = head.getChainListDto();
            System.out.println("Element" + index + "��key-" + dtoTemp.getKey() + "name-" + dtoTemp.getName() + "age-" + dtoTemp.getAge());
            head = head.getNextNode();
        }
    }

    private String updateNode(ChainListType head,ChainListType node,String key) {
        String result = "";
        if(head == null){
            head = node;
        }
        //�ҵ�Ҫ����λ�õ�ǰһ�ڵ�
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
            System.out.println("�����ڵ�nodeδ��ʼ��");
        }
        if(head == null){
            head = node;
            return head;
        }
        while(head != null){
            tempNode = head;//������ǰ�ڵ�
            head = head.getNextNode();//������ǰ�ڵ����һ�ڵ�
        }
        tempNode.setNextNode(node);//�����ڵ�׷���½ڵ�node
        return tempNode.getNextNode();//����ͷ���
    }

    public ChainListDto innitData(int i){
        ChainListDto chainListDto = new ChainListDto();
        chainListDto.setKey("element" + i);
        chainListDto.setName("ZhangSan");
        chainListDto.setAge(10);
        return chainListDto;
    }
}
