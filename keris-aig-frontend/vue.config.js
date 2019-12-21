const VueLoaderPlugin = require("vue-loader/lib/plugin");

module.exports = {
  "transpileDependencies": [
    "vuetify"
  ],
  configureWebpack: {
    devServer: {
      //zhost: 'aig.edunet.net',
      //port: '80'
      host: 'localhost',
      port: '8080'
    }
  }
}