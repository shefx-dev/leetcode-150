boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (p == null || q == null) return false;
    if (p.val != q.val) return false;

    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
}


boolean isSameTree(TreeNode p, TreeNode q) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(p);
    queue.add(q);

    while (!queue.isEmpty()) {
        TreeNode a = queue.poll();
        TreeNode b = queue.poll();

        if (a == null && b == null) continue;
        if (a == null || b == null) return false;
        if (a.val != b.val) return false;

        queue.add(a.left);
        queue.add(b.left);
        queue.add(a.right);
        queue.add(b.right);
    }
    return true;
}
