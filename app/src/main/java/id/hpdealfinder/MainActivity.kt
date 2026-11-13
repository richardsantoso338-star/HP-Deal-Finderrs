package id.hpdealfinder

import android.app.Activity
import android.os.Bundle
import android.content.Intent
import android.net.Uri
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.*

class MainActivity : Activity() {
    private fun dp(v: Int) = (v * resources.displayMetrics.density).toInt()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(20), dp(24), dp(20), dp(20))
            setBackgroundColor(Color.rgb(247,249,252))
        }
        val title = TextView(this).apply { text = "HP Deal Finder"; textSize = 28f; setTextColor(Color.rgb(20,35,60)); setTypeface(null, 1) }
        root.addView(title)
        val sub = TextView(this).apply { text = "Cari penawaran HP bekas di Facebook Marketplace"; textSize = 14f; setTextColor(Color.DKGRAY); setPadding(0,dp(6),0,dp(18)) }
        root.addView(sub)
        val query = EditText(this).apply { hint = "Contoh: POCO F6, iPhone 13, Samsung S23"; textSize = 15f; singleLine = true; setPadding(dp(12),dp(12),dp(12),dp(12)); setBackgroundColor(Color.WHITE) }
        root.addView(query, LinearLayout.LayoutParams(-1, dp(54)))
        val maxPrice = EditText(this).apply { hint = "Harga maksimal (contoh: 3000000)"; inputType = 2; textSize=15f; setPadding(dp(12),dp(12),dp(12),dp(12)); setBackgroundColor(Color.WHITE) }
        val p = LinearLayout.LayoutParams(-1, dp(54)); p.topMargin=dp(12); root.addView(maxPrice,p)
        val days = Spinner(this)
        days.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listOf("Semua tanggal", "1 hari terakhir", "7 hari terakhir", "14 hari terakhir", "30 hari terakhir"))
        val s = LinearLayout.LayoutParams(-1, dp(50)); s.topMargin=dp(10); root.addView(days,s)
        val search = Button(this).apply { text = "Cari di Facebook Marketplace"; textSize=15f }
        val b = LinearLayout.LayoutParams(-1, dp(54)); b.topMargin=dp(16); root.addView(search,b)
        val note = TextView(this).apply {
            text = "Cara kerja: aplikasi membuka pencarian Marketplace di browser agar kamu login sendiri. Facebook dapat membatasi hasil berdasarkan akun/lokasi. Filter harga dan tanggal tetap perlu diperiksa di Marketplace. Aplikasi tidak meminta atau menyimpan kata sandi Facebook."
            textSize=13f; setTextColor(Color.DKGRAY); setPadding(0,dp(18),0,dp(12))
        }
        root.addView(note)
        val safety = TextView(this).apply {
            text = "Tips aman: jangan transfer uang muka, cek IMEI, tes kamera/layar/sinyal, dan bertemu di tempat umum."
            textSize=13f; setTextColor(Color.rgb(30,100,70))
        }
        root.addView(safety)
        search.setOnClickListener {
            val term = query.text.toString().trim()
            if (term.isEmpty()) { query.error = "Masukkan merek atau model HP"; return@setOnClickListener }
            val price = maxPrice.text.toString().trim()
            val q = if (price.isNotEmpty()) "$term under $price" else term
            val url = "https://www.facebook.com/marketplace/search/?query=" + Uri.encode(q)
            try { startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url))) }
            catch (_: Exception) { Toast.makeText(this, "Browser tidak ditemukan", Toast.LENGTH_LONG).show() }
        }
        setContentView(ScrollView(this).apply { addView(root) })
    }
}
