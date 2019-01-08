enum Owner {
    X, O, EMPTY;

    Owner GetOpposite() {
        switch (this) {
        case X:
            return Owner.O;
        case O:
            return Owner.X;
        default:
            return Owner.EMPTY;
        }
    }
}