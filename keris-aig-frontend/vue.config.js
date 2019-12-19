const VueLoaderPlugin = require("vue-loader/lib/plugin");

module.exports = {
  "transpileDependencies": [
    "vuetify"
  ],
  configureWebpack: {
    devServer: {
      host: 'aig.edunet.net',
      port: '80'
    }
  }
}