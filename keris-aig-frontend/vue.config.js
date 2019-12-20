const VueLoaderPlugin = require("vue-loader/lib/plugin");

module.exports = {
  "transpileDependencies": [
    "vuetify"
  ],
  configureWebpack: {
    devServer: {
      host: 'localhost',
      port: '8080'
    }
  }
}