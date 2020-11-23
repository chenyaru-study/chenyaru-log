import java.util.Scanner;
import java.util.logging.Logger;

/**
 * ���ݽṹ-������ѧϰ���Զ�����������ɾ�����
 */
public class CBTTypeDemoMain {
    private static final Logger logger = Logger.getLogger(CBTTypeDemoMain.class.getName());
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        //��ʼ��������
        CBTType rootNode = initTree();
        if(rootNode == null) {
            logger.info("��ʼ��������ʧ�ܣ�");
        } else {
            //��Ӷ������ڵ�Ԫ��
            logger.info("��ѡ���Ƿ���ӽڵ㣬1����ӣ�2�������");
            Integer addFlag = in.nextInt();
            do{
                if(addFlag == 1) {
                    CBTType resultNode = addNode(rootNode);
                    if(resultNode == null) {
                        logger.info("��ӽڵ�ʧ�ܣ�����Ϊ���������нڵ㣬��˲�����Ԫ��(������ʽ���������(��-��-��))");
                        //�����������������-��-�ҡ�
                        queryTreeByDLR(rootNode);
                        break;
                    }
                    logger.info("��ѡ���Ƿ���ӽڵ㣬1����ӣ�2�������");
                    addFlag = in.nextInt();
                } else {
                    logger.info("����ѡ����Ч����ֹ��ӽڵ�Ԫ�أ�");
                }

            }while(addFlag == 1);//do{}while(�������ʽ) ѭ����ֱ�������������ʽʱִ��
            //�����������������-��-�ҡ�
            //queryTreeByDLR(rootNode);
            //�����������������-��-�ҡ�
            //queryTreeByLDR(rootNode);
            //�����������������-��-����
            queryTreeByLRD(rootNode);

            //������������
            int depth = treeDepth(rootNode);
            logger.info("���������ǰ����ȣ�" + String.valueOf(depth));

            //������������нڵ�  Exhaustive Attack method
            rootNode = clearTree(rootNode);
            depth = treeDepth(rootNode);
            logger.info("��������������ȣ�" + String.valueOf(depth));
        }
    }

    /**
     * ��ʼ�����������ڵ�
     * @return ���ڵ�
     */
    private static CBTType initTree(){
        CBTType node = new CBTType();
        node.setData("A");
        node.setLeft(null);
        node.setRight(null);
        if(node == null) {
            return null;
        } else {
            return node;
        }
    }

    /**
     * �����ڵ�
     * @param rootNode ���ڵ�
     * @return �����ڵ�
     */
    private static CBTType addNode(CBTType rootNode){
        //���������ڵ�Ԫ��
        logger.info("�����������ڵ�Ԫ�����ݣ�");
        String data = in.next();
        CBTType newNode = new CBTType();
        newNode.setData(data);
        newNode.setLeft(null);
        newNode.setRight(null);

        //�����ڵ㸸�ڵ�
        logger.info("�����������ڵ�ĸ��ڵ�Ԫ�����ݣ�");
        String parentNodeData = in.next();
        CBTType parentNode = findNode(rootNode,parentNodeData);
        if(parentNode == null){
            logger.info("�Ҳ��������ڵ�ĸ��ڵ�Ԫ�����ݣ�");
            newNode = null;
        } else {
            logger.info("�����������ڵ�λ�ڸ��ڵ��λ�ã�1����������2��������");
            Integer index = in.nextInt();
            switch(index){
                case 1:
                    if(parentNode.getLeft() != null) {
                        logger.info("���ڵ����������Ϊ�գ��޷���ӣ�");
                        newNode = null;
                    } else {
                        parentNode.setLeft(newNode);
                        logger.info("�����ڵ�ɹ������ڵ㣺" + parentNode.getData() + " �����ڵ㣺" + newNode.getData());
                    }
                    break;
                case 2:
                    if(parentNode.getRight() != null) {
                        logger.info("���ڵ����������Ϊ�գ��޷���ӣ�");
                        newNode = null;
                    } else {
                        parentNode.setRight(newNode);
                        logger.info("�����ڵ�ɹ������ڵ㣺" + parentNode.getData() + " �����ڵ㣺" + newNode.getData());
                    }
                    break;
                default:
                    logger.info("����λ����Ч�����ʧ�ܣ�");
                    newNode = null;
                    break;
            }
        }
        return newNode;
    }

    /**
     * ���ҽڵ�
     * @param node ������������ڵ�
     * @param parentNodeData  �����ڵ�ĸ��ڵ�Ԫ������
     * @return �����ڵ�ĸ��ڵ�
     */
    private static CBTType findNode(CBTType node, String parentNodeData) {
        //��ʱ�ڵ����������ÿ�εݹ��ѯ���ӽڵ����
        CBTType tempNode = null;
        //���ڵ�Ϊ�գ��޷���ѯ
        if(node == null || "".equals(node.getData())) {
            return null;
        }
        //�ҵ��ڵ㣬����
        if(parentNodeData.equals(node.getData())){
            return node;
        } else {
            CBTType leftNode = null;
            CBTType rightNode = null;
            //�ݹ���ö��������������������������������ڵ�ĸ��ڵ�
            if((tempNode = node.getLeft()) != null) {
                leftNode = findNode(tempNode,parentNodeData);
            }
            if((tempNode = node.getRight()) != null) {
                rightNode = findNode(tempNode,parentNodeData);
            }
            //�������������нڵ㣬��δ�鵽�����ڵ�ĸ��ڵ㣬����null
            if(leftNode != null) {
                return leftNode;
            } else if(rightNode != null) {
                return rightNode;
            } else {
                return null;
            }
        }
    }

    /**
     * �����������������-��-��
     * @param node ��ǰ�ڵ�
     * @return
     */
    private static String queryTreeByDLR(CBTType node){
        if(node == null) {
            return "error";
        } else {
            //��ӡ�ڵ�Ԫ������
            printNodeData(node);
            //�ݹ����������
            queryTreeByDLR(node.getLeft());
            //�ݹ����������
            queryTreeByDLR(node.getRight());
            return "success";
        }
    }

    /**
     * �����������������-��-�ҡ�
     * @param node ��ǰ�ڵ�
     * @return
     */
    private static String queryTreeByLDR(CBTType node){
        if(node == null) {
            return "error";
        } else {
            //�ݹ����������
            queryTreeByLDR(node.getLeft());
            //��ӡ�ڵ�Ԫ������
            printNodeData(node);
            //�ݹ����������
            queryTreeByLDR(node.getRight());
            return "success";
        }
    }

    /**
     * �����������������-��-����
     * @param node
     * @return
     */
    private static String queryTreeByLRD(CBTType node){
        if(node == null) {
            return "error";
        } else {
            //�ݹ����������
            queryTreeByLRD(node.getLeft());
            //�ݹ����������
            queryTreeByLRD(node.getRight());
            //��ӡ�ڵ�Ԫ������
            printNodeData(node);
            return "success";
        }
    }

    /**
     * ��ӡ�������ڵ�����
     * @param node
     */
    private static void printNodeData(CBTType node) {
        logger.info(" " + node.getData());
    }

    /**
     * ������������
     * @param node ���ڵ�
     * @return �������ֵ
     */
    private static Integer treeDepth(CBTType node){
        int leftDepth;
        int rightDepth;
        if(node == null) {
            return 0;
        } else {
            //����������������ݹ������������
            leftDepth = treeDepth(node.getLeft());
            rightDepth = treeDepth(node.getRight());
            if(leftDepth > rightDepth) {
               return ++leftDepth;
            } else
               return ++rightDepth;
            }
    }

    /**
     * ������������нڵ�
     * @param node ���ڵ�
     * @return �����ĸ��ڵ�
     */
    private static CBTType clearTree(CBTType node){
        if(node == null) {
            return node;
        } else {
            clearTree(node.getLeft());
            clearTree(node.getRight());
            node = null;
            return node;
        }

    }
}
