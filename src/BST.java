/**
 * @author vikky.agrawal
 *
 */

public class BST {

	private TreeNode root = new TreeNode(5);

	public static void main(String[] args) {

		new BST().BSToperation();
	}

	public void BSToperation() {

		System.out.println("Building tree with root value " + root.getData());
		insert(root, 1);
		insert(root, 8);
		insert(root, 6);
		insert(root, 3);
		insert(root, 9);
		System.out.println("Traversing tree in in-order");
		inorder(root);

		System.out.println("Traversing tree in  reverse-order");
		reverseorder(root);

		System.out.println("Traversing tree in  post-order");
		postOrder(root);

		System.out.println("Find whether sum=11 exists in tree : "
				+ findSum(root, 12));

	}

	public void insert(TreeNode root, int val) {
		if (root == null) {
			root = new TreeNode(val);
			return;
		} else {
			if (val < root.getData()) {
				if (root.getLeft() == null) {
					System.out.println("inserting left to :" + root.getData()
							+ " val : " + val);
					root.setLeft(new TreeNode(val));
				} else {
					insert(root.getLeft(), val);
				}
			} else {
				if (root.getRight() == null) {
					System.out.println("inserting right to :" + root.getData()
							+ " val : " + val);
					root.setRight(new TreeNode(val));
				} else {
					insert(root.getRight(), val);
				}
			}
		}
	}

	public void inorder(TreeNode root) {
		if (root != null) {
			inorder(root.getLeft());
			System.out.println(root.getData());
			inorder(root.getRight());
		}
	}

	/*
	 * Right -root -left
	 */
	public void reverseorder(TreeNode root) {
		if (root != null) {
			reverseorder(root.getRight());
			System.out.println(root.getData());
			reverseorder(root.getLeft());
		}
	}

	/*
	 * Right -left - root
	 */
	public void postOrder(TreeNode root) {
		if (root != null) {
			postOrder(root.getRight());
			postOrder(root.getLeft());
			System.out.println(root.getData());

		}
	}

	/*
	 * O(n log(n) solution. finding for each node using BST property.
	 */
	public boolean findSum(TreeNode root, int val) {
		if (root != null) {
			// for each node find whether its counterpart exists?
			TreeNode left = root.getLeft();
			TreeNode right = root.getRight();
			return (findSum(left, val) || find(this.root, val - root.getData()) || findSum(
					right, val));
		}
		return false;
	}

	/*
	 * O(log n) helper function
	 */

	private boolean find(TreeNode root, int val) {
		if (root != null) {
			if (root.getData() == val) {
				return true;
			} else if (root.getData() > val) {
				return find(root.getLeft(), val);
			} else {
				return find(root.getRight(), val);
			}
		}
		return false;
	}

	/*
	 * public boolean findSum(TreeNode root, int val){ if(root!=null){
	 * 
	 * //traverse only left if root.data-val <=0 if(val-root.getData() <= 0){
	 * return findSum(root.getLeft(), val); }else { //scenario 1: when
	 * root.data-val < root.data if(val-root.getData() < root.getData()){
	 * if(find(root.getLeft(),val-root.getData())){ return true; }else{ return
	 * findSum(root.getLeft(), val); } } //scenario 2: traversing to the right.
	 * else{ if(find(root.getRight(),val-root.getData())){ return true; }else{
	 * return findSum(root.getRight(), val); } } }
	 * 
	 * } return false;
	 * 
	 * }
	 */

}
