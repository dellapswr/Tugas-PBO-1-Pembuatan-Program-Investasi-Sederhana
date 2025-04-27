class SuratBerhargaNegara {
    String nama;
    double bunga;
    int jangkaWaktu;
    String tanggalJatuhTempo;
    double kuotaNasional;

    public SuratBerhargaNegara(String n, double b, int j, String t, double k) {
        nama = n; bunga = b; jangkaWaktu = j; tanggalJatuhTempo = t; kuotaNasional = k;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SuratBerhargaNegara)) return false;
        SuratBerhargaNegara s = (SuratBerhargaNegara) o;
        return nama.equals(s.nama);
    }

    @Override
    public int hashCode() {
        return nama.hashCode();
    }
}
