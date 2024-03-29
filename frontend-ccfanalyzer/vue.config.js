// const BundleAnalyzerPlugin = require('webpack-bundle-analyzer').BundleAnalyzerPlugin
module.exports = {
  configureWebpack: {
    plugins: [
      new BundleAnalyzerPlugin()
    ],
    externals: { // 排除一些引入的模块，不进行打包
      vue: 'Vue',
      axios: 'axios',
      'element-ui': 'ElementUI'
    }
  },
  devServer: {
    // 调试端口
    // port: 8989
    proxy: {
      '/api': {
        target: 'http://47.97.288.185:8080',
        changeOrigin: true,
        ws: true,
        pathRewrite: {
          '^/api': ''
        }
      }
    }
  }
}
