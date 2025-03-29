public class Vector2D { //creando una interfaz gráfica
    public int x, y;

    public Vector2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D sumar(Vector2D otro){
        return new Vector2D(x + otro.x, y + otro.y);
    }

    public Vector2D restar(Vector2D otro){
        return new Vector2D(x - otro.x, y - otro.y);
    }

    public Vector2D multiplicar(Vector2D otro){
        return new Vector2D(x * otro.x, y * otro.y);
    }

    public Vector2D dividir(Vector2D otro){
        return new Vector2D(x / otro.x, y / otro.y);
    }

    @Override //sobrecarga de metodo toString()
    public String toString(){
        return "("+x+"i +" +y+"j )";
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
