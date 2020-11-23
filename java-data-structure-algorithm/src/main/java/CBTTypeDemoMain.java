import java.util.Scanner;
import java.util.logging.Logger;

/**
 * 数据结构-二叉树学习：对二叉树进行增删查操作
 */
public class CBTTypeDemoMain {
    private static final Logger logger = Logger.getLogger(CBTTypeDemoMain.class.getName());
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        //初始化二叉树
        CBTType rootNode = initTree();
        if(rootNode == null) {
            logger.info("初始化二叉树失败！");
        } else {
            //添加二叉树节点元素
            logger.info("请选择是否添加节点，1：添加；2：不添加");
            Integer addFlag = in.nextInt();
            do{
                if(addFlag == 1) {
                    CBTType resultNode = addNode(rootNode);
                    if(resultNode == null) {
                        logger.info("添加节点失败！以下为二叉树现有节点，请核查新增元素(遍历方式：先序遍历(根-左-右))");
                        //先序遍历二叉树【根-左-右】
                        queryTreeByDLR(rootNode);
                        break;
                    }
                    logger.info("请选择是否添加节点，1：添加；2：不添加");
                    addFlag = in.nextInt();
                } else {
                    logger.info("输入选项无效，终止添加节点元素！");
                }

            }while(addFlag == 1);//do{}while(条件表达式) 循环：直到满足条件表达式时执行
            //先序遍历二叉树【根-左-右】
            //queryTreeByDLR(rootNode);
            //中序遍历二叉树【左-根-右】
            //queryTreeByLDR(rootNode);
            //后序遍历二叉树【左-右-根】
            queryTreeByLRD(rootNode);

            //计算二叉树深度
            int depth = treeDepth(rootNode);
            logger.info("清楚二叉树前的深度：" + String.valueOf(depth));

            //清楚二叉树所有节点  Exhaustive Attack method
            rootNode = clearTree(rootNode);
            depth = treeDepth(rootNode);
            logger.info("清除二叉树后的深度：" + String.valueOf(depth));
        }
    }

    /**
     * 初始化二叉树根节点
     * @return 根节点
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
     * 新增节点
     * @param rootNode 根节点
     * @return 新增节点
     */
    private static CBTType addNode(CBTType rootNode){
        //创建新增节点元素
        logger.info("请输入新增节点元素数据：");
        String data = in.next();
        CBTType newNode = new CBTType();
        newNode.setData(data);
        newNode.setLeft(null);
        newNode.setRight(null);

        //新增节点父节点
        logger.info("请输入新增节点的父节点元素数据：");
        String parentNodeData = in.next();
        CBTType parentNode = findNode(rootNode,parentNodeData);
        if(parentNode == null){
            logger.info("找不到新增节点的父节点元素数据！");
            newNode = null;
        } else {
            logger.info("请输入新增节点位于父节点的位置，1：左子树；2：右子树");
            Integer index = in.nextInt();
            switch(index){
                case 1:
                    if(parentNode.getLeft() != null) {
                        logger.info("父节点的左子树不为空，无法添加！");
                        newNode = null;
                    } else {
                        parentNode.setLeft(newNode);
                        logger.info("新增节点成功，父节点：" + parentNode.getData() + " 新增节点：" + newNode.getData());
                    }
                    break;
                case 2:
                    if(parentNode.getRight() != null) {
                        logger.info("父节点的右子树不为空，无法添加！");
                        newNode = null;
                    } else {
                        parentNode.setRight(newNode);
                        logger.info("新增节点成功，父节点：" + parentNode.getData() + " 新增节点：" + newNode.getData());
                    }
                    break;
                default:
                    logger.info("输入位置无效，添加失败！");
                    newNode = null;
                    break;
            }
        }
        return newNode;
    }

    /**
     * 查找节点
     * @param node 二叉树的任意节点
     * @param parentNodeData  新增节点的父节点元素数据
     * @return 新增节点的父节点
     */
    private static CBTType findNode(CBTType node, String parentNodeData) {
        //临时节点变量，保存每次递归查询的子节点变量
        CBTType tempNode = null;
        //根节点为空，无法查询
        if(node == null || "".equals(node.getData())) {
            return null;
        }
        //找到节点，返回
        if(parentNodeData.equals(node.getData())){
            return node;
        } else {
            CBTType leftNode = null;
            CBTType rightNode = null;
            //递归调用二叉树的左子树和右子树，查找新增节点的父节点
            if((tempNode = node.getLeft()) != null) {
                leftNode = findNode(tempNode,parentNodeData);
            }
            if((tempNode = node.getRight()) != null) {
                rightNode = findNode(tempNode,parentNodeData);
            }
            //遍历二叉树所有节点，仍未查到新增节点的父节点，返回null
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
     * 先序遍历左子树：根-左-右
     * @param node 当前节点
     * @return
     */
    private static String queryTreeByDLR(CBTType node){
        if(node == null) {
            return "error";
        } else {
            //打印节点元素数据
            printNodeData(node);
            //递归遍历左子树
            queryTreeByDLR(node.getLeft());
            //递归遍历右子树
            queryTreeByDLR(node.getRight());
            return "success";
        }
    }

    /**
     * 中序遍历二叉树【左-根-右】
     * @param node 当前节点
     * @return
     */
    private static String queryTreeByLDR(CBTType node){
        if(node == null) {
            return "error";
        } else {
            //递归遍历左子树
            queryTreeByLDR(node.getLeft());
            //打印节点元素数据
            printNodeData(node);
            //递归遍历右子树
            queryTreeByLDR(node.getRight());
            return "success";
        }
    }

    /**
     * 后序遍历二叉树【左-右-根】
     * @param node
     * @return
     */
    private static String queryTreeByLRD(CBTType node){
        if(node == null) {
            return "error";
        } else {
            //递归遍历左子树
            queryTreeByLRD(node.getLeft());
            //递归遍历右子树
            queryTreeByLRD(node.getRight());
            //打印节点元素数据
            printNodeData(node);
            return "success";
        }
    }

    /**
     * 打印二叉树节点数据
     * @param node
     */
    private static void printNodeData(CBTType node) {
        logger.info(" " + node.getData());
    }

    /**
     * 计算二叉树深度
     * @param node 根节点
     * @return 计算深度值
     */
    private static Integer treeDepth(CBTType node){
        int leftDepth;
        int rightDepth;
        if(node == null) {
            return 0;
        } else {
            //后序遍历二叉树，递归计算二叉树深度
            leftDepth = treeDepth(node.getLeft());
            rightDepth = treeDepth(node.getRight());
            if(leftDepth > rightDepth) {
               return ++leftDepth;
            } else
               return ++rightDepth;
            }
    }

    /**
     * 清楚二叉树所有节点
     * @param node 根节点
     * @return 清楚后的根节点
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
