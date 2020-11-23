/**
 * 数据结构-链表学习
 * Created by c_chenyaru on 2020/10/23.
 */
public class ChainListType {
    ChainListDto chainListDto;
    ChainListType nextNode;

    public ChainListType() {
    }


    public ChainListDto getChainListDto() {
        return chainListDto;
    }

    public void setChainListDto(ChainListDto chainListDto) {
        this.chainListDto = chainListDto;
    }

    public ChainListType getNextNode() {
        return nextNode;
    }

    public void setNextNode(ChainListType nextNode) {
        this.nextNode = nextNode;
    }
}
