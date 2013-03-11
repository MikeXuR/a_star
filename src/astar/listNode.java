/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package astar;

/**
 *
 * @author akshay
 */
public class listNode {
        public node n;
        public listNode parent;
        public int g_score;
        listNode(node n1,listNode p,int gval)
        {
            n=n1;
            parent = p;
            g_score=gval;
        }
        listNode(){}
        @Override
        public boolean equals(Object obj) 
        {
                if(obj ==null) return false;
                if(getClass()!=obj.getClass()) return false;
                listNode other=(listNode) obj;
                return n.equals(other.n);
        }
        public boolean checkParent()
        {
            if(parent==null)
            {
                return false;
            }
            else
            {
                if(n.equals(parent))
                {
                    return true;
                }
                else
                {
                    parent.checkParent();
                }
            }
            return false;
        }
}
